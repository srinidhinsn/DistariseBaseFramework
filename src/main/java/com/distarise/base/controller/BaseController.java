package com.distarise.base.controller;

import com.distarise.base.action.BaseAction;
import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.FileUploadDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.properties.FileStorageProperties;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.FileStorageService;
import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author NSN
 * @since 04/08/2020
 */
@Controller
public class BaseController {

    private final String GUEST_USER = "guest";

    @Autowired
    UserService userService;

    @Autowired
    BaseService baseService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private FileStorageProperties fileStorageProperties;

    @RequestMapping("/")
    public String viewHome() {
        return "home";
    }

    @RequestMapping(value = "/nsn/{client}/{module}/{page}")
    public String genericController(@PathVariable("module") String module,
                                    @PathVariable("client") String client,
                                    @PathVariable("page") String page,
                                    @RequestParam(value = "file", required=false) MultipartFile file,
                                    @RequestParam(value = "files", required=false) MultipartFile[] files,
                                    Model model,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        PageDetailsDto pageDetailsDto = null;
        UserDetailsDto userDetailsDto = null;

        if (null != request.getAttribute(BaseAction.PAGE_DETAILS)){
            pageDetailsDto = (PageDetailsDto) request.getAttribute(BaseAction.PAGE_DETAILS);
        }
        else{
            if (null == session.getAttribute(UserService.USER)){
                userDetailsDto = userService.getUserDetails(GUEST_USER, GUEST_USER,
                        client);
                session.setAttribute(UserService.USER, userDetailsDto);
            } else {
                userDetailsDto = (UserDetailsDto) session.getAttribute(UserService.USER);
                if (!userDetailsDto.getClientId().equals(client)){
                    userDetailsDto = userService.getUserDetails(GUEST_USER, GUEST_USER,
                            client);
                    session.setAttribute(UserService.USER, userDetailsDto);
                }
            }
            BaseContextDto baseContextDto = new BaseContextDto(client, module, page, userDetailsDto);
            pageDetailsDto = baseService.getPageDetails(baseContextDto);
            pageDetailsDto.setUsername(userDetailsDto.getFirstname()+" "+userDetailsDto.getLastname());
            request.setAttribute(BaseAction.PAGE_DETAILS, pageDetailsDto);
            baseService.preloadWidgets(request, pageDetailsDto, baseContextDto);
        }

        if (file != null){
            pageDetailsDto.getFileUploads().add(uploadFile(file));
        } else if (files != null){
            pageDetailsDto.setFileUploads(uploadMultipleFiles(files));
        }

        pageDetailsDto.setUrl(request.getRequestURI());
        model.addAttribute("pageDetails", pageDetailsDto);
        return "distarise";
    }

    private FileUploadDto uploadFile(MultipartFile file){
        String fileName = fileStorageService.storeFile(file);
        return new FileUploadDto(fileName, fileStorageProperties.getLocation(),
                file.getContentType(), file.getSize());
    }

    private List<FileUploadDto> uploadMultipleFiles(MultipartFile[] files){
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }
}

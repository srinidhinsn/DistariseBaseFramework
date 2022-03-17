package com.distarise.base.controller;

import com.distarise.base.action.BaseAction;
import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/")
    public String viewHome() {
        return "home";
    }

    @RequestMapping(value = "/nsn/{client}/{module}/{page}")
    public String genericController(@PathVariable("module") String module,
                                    @PathVariable("client") String client,
                                    @PathVariable("page") String page,
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
            request.setAttribute(BaseAction.PAGE_DETAILS, pageDetailsDto);
            baseService.preloadWidgets(request, pageDetailsDto, baseContextDto);
        }

        pageDetailsDto.setUrl(request.getRequestURI());
        model.addAttribute("pageDetails", pageDetailsDto);
        return "distarise";
    }

}

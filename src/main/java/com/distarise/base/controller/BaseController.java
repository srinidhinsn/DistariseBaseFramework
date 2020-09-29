package com.distarise.base.controller;

import com.distarise.base.action.BaseAction;
import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.AbstractBaseService;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author NSN
 * @since 04/08/2020
 */
@Controller
public class BaseController {

    public final static String GUEST_USER = "guest";
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    UserService userService;

    @Autowired
    BaseService baseService;

    @RequestMapping("/")
    public String viewHome() {
        return "redirect:/shopping/aboutus";
    }

    @RequestMapping(value = "/{client}/{module}/{page}")
    public String genericController(@PathVariable("module") String module,
                                    @PathVariable("client") String client,
                                    @PathVariable("page") String page,
                                    Model model,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        PageDetailsDto pageDetailsDto = null;
        UserDetailsDto userDetailsDto = null;
        BaseContextDto baseContextDto = null;
        if (null != request.getAttribute(BaseAction.PAGE_DETAILS)){
            pageDetailsDto = (PageDetailsDto) request.getAttribute(BaseAction.PAGE_DETAILS);
        }
        else{
            baseContextDto = (BaseContextDto) session.getAttribute(AbstractBaseService.BASE_CONTEXT);
            userDetailsDto = baseContextDto.getUserDetailsDto();
            baseContextDto.setClientId(client);
            baseContextDto.setPageName(page);
            baseContextDto.setModule(module);
            logger.info("Role Name - "+userDetailsDto.getRoleName());
            logger.info("User Id - "+userDetailsDto.getUserId());
            logger.info("First Name - "+userDetailsDto.getFirstname());
            logger.info("Client Name - "+userDetailsDto.getClientId());
            pageDetailsDto = baseService.getPageDetails(baseContextDto);
            request.setAttribute(BaseAction.PAGE_DETAILS, pageDetailsDto);
            baseService.preloadWidgets(request, pageDetailsDto, baseContextDto);
        }

        pageDetailsDto.setUrl(request.getRequestURI());
        model.addAttribute("pageDetails", pageDetailsDto);
        return client;
    }

}

package com.distarise.base.controller;

import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserRoleDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author NSN
 * @since 04/08/2020
 */
@Controller
public class BaseController {

    @Autowired
    UserService userService;

    @Autowired
    BaseService baseService;

    @RequestMapping("/")
    public String viewHome() {
        return "welcome";
    }


    @RequestMapping("/login")
    public String login(Model model) {

        model.addAttribute("uinav", new UINav());
        return "index";
    }

    @RequestMapping("/home")
    public String home(@ModelAttribute UINav uiNav) {
        System.out.println("username - "+ uiNav.getUsername());
        System.out.println("passwrd - "+uiNav.getPassword());
        return "home";
    }

    @RequestMapping(value = "/{client}/{module}/{page}")
    public String genericController(@PathVariable("module") String module,
                                    @PathVariable("client") String client,
                                    @PathVariable("page") String page,
                                    Model model,
                                    HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null != request.getParameter("pageDetails")){
            //PageDetailsDto pageDetailsDto2 = (PageDetailsDto) request.getParameter("pageDetails");
        }
        Optional<UserRoleDto> userRoleDto = Optional.ofNullable((UserRoleDto) session.getAttribute("userRoleDto"));
        BaseContextDto baseContextDto = new BaseContextDto(client, module, page, userRoleDto);
        PageDetailsDto pageDetailsDto = baseService.getPageDetails(baseContextDto);
        pageDetailsDto.setUrl(request.getRequestURI());
        model.addAttribute("pageDetails", pageDetailsDto);
        return "distarise";
    }
/*
    @RequestMapping(value = "/{client}/{module}/{page}")
    public String genericController(@PathVariable("module") String module,
                                    @PathVariable("client") String client,
                                    @PathVariable("page") String page,
                                    @ModelAttribute UINav uiNav,
                                    Model model) {
        System.out.println("Module- "+module);
        System.out.println("Client - "+client);
        System.out.println("Page - "+page);


        model.addAttribute("client",uiNav);
        return "index";
    }
    */
}

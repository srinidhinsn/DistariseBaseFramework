package com.distarise.base.controller;

import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author NSN
 * @since 04/08/2020
 */
@Controller
public class BaseController {

    @Autowired
    UserService userService;

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
                                    @ModelAttribute UINav uiNav,
                                    Model model) {
        System.out.println("Module- "+module);
        System.out.println("Client - "+client);
        System.out.println("Page - "+page);
        UserDetailsDto userDetailsDto = userService.getUserDetails(uiNav.getUsername(), uiNav.getPassword());
        if (null != userDetailsDto){
            System.out.println("Login success - "+userDetailsDto.getUserId());
        } else {
            System.out.println("Login failure");
        }

        model.addAttribute("client",uiNav);
        return "index";
    }
}

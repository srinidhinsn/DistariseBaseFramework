package com.distarise.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author NSN
 * @since 04/08/2020
 */
@Controller
public class HomeController {

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
}

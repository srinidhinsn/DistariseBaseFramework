package com.distarise.base.action;

import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LogoutAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    UserService userService;

    @Override
    public void executeAction(){
        HttpSession session = request.getSession();
        session.setAttribute(UserService.USER, null);
    }

}

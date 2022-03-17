package com.distarise.base.action;

import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    UserService userService;

    @Override
    public void executeAction(){
        WidgetDto sourceWidgetDto = super.executeAction(new WidgetDto());
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        sourceWidgetDto.getComponentDtos().forEach(componentDto -> {
            if(componentDto.getId().equalsIgnoreCase("username")){
                userDetailsDto.setUserId(componentDto.getValue());
            } else if (componentDto.getId().equalsIgnoreCase("password")){
                userDetailsDto.setPassword(componentDto.getValue());
            }
        });
        UserDetailsDto retrievedUser = userService.getUserDetails(userDetailsDto.getUserId(), userDetailsDto.getPassword(),
                getClientId());
        HttpSession session = request.getSession(true);
        session.setAttribute(UserService.USER, retrievedUser);
    }

}

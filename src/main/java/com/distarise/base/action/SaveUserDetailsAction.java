package com.distarise.base.action;

import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveUserDetailsAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private UserService userService;

    public void executeAction() {
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto) request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        String title = request.getParameter("column1");
        String userId = request.getParameter("column2");
        String firstName = request.getParameter("column3");
        String lastName = request.getParameter("column4");
        String password = request.getParameter("column5");
        String rolename = request.getParameter("column6");
        UserDetailsDto userDetailsDto = new UserDetailsDto(configPageDetailsDto.getClientId(), userId, password,
                title, firstName, lastName, rolename, null);
        userService.saveUserRole(userDetailsDto);
    }
}

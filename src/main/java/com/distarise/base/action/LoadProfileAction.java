package com.distarise.base.action;

import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class LoadProfileAction extends AbstractBaseAction implements BaseAction {
    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        UserDetailsDto userDetailsDto = (UserDetailsDto) request.getSession().getAttribute(UserService.USER);
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("account")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("firstname")){
                                targetComponentDto.setValue(userDetailsDto.getFirstname());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("lastname")){
                                targetComponentDto.setValue(userDetailsDto.getLastname());
                            } else if(targetComponentDto.getId().equalsIgnoreCase("role")){
                                targetComponentDto.setValue(userDetailsDto.getRoleName());
                            }
                        });
                    }
                });
            }
        });
    }
}

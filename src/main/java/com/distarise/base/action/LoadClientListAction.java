package com.distarise.base.action;

import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class LoadClientListAction extends AbstractBaseAction implements BaseAction {
    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        UserDetailsDto userDetailsDto = (UserDetailsDto) request.getSession().getAttribute(UserService.USER);
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("addclient")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("clientlist")){
                                targetComponentDto.getComponentItemDtos().add(new ComponentItemDto(
                                        "clientlist", "distarise" , 2, "test", "Test", false, true
                                ));
                            }
                        });
                    }
                });
            }
        });
    }
}

package com.distarise.base.action;

import com.distarise.base.actionextension.LoadNavigationsActionExt;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveLandingPageAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private LoadNavigationsActionExt loadNavigationsActionExt;

    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto)
                request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        String clientId = configPageDetailsDto.getClientDto().getId();
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("addlandingpage")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("navigationgrid")){
                                loadNavigationsActionExt.preloadNavigationsForm(request, targetComponentDto, clientId);
                            } else if (targetComponentDto.getId().equalsIgnoreCase("clientid")){
                                targetComponentDto.setValue(clientId);
                            }
                        });
                    }
                });
            }
        });
    }
}

package com.distarise.base.action;

import com.distarise.base.actionextension.LoadClientDetailsActionExt;
import com.distarise.base.actionextension.LoadNavigationsActionExt;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.ClientService;
import com.distarise.base.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadNavigationsAction extends AbstractBaseAction implements BaseAction {

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
                    if (targetWidgetDto.getId().equalsIgnoreCase("addnavigation")){
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

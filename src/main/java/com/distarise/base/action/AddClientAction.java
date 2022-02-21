package com.distarise.base.action;

import com.distarise.base.model.ClientDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddClientAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    ClientService clientService;

    @Override
    public void executeAction(){
        WidgetDto sourceWidgetDto = super.executeAction(new WidgetDto());
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        ClientDto clientDto = new ClientDto();
        sourceWidgetDto.getComponentDtos().forEach(componentDto -> {
            if (componentDto.getId().equalsIgnoreCase("clientname")){
                clientDto.setId(componentDto.getValue());
            } else if (componentDto.getId().equalsIgnoreCase("clientheader")){
                clientDto.setHeader(componentDto.getValue());
            } else if (componentDto.getId().equalsIgnoreCase("clientfooter")){
                clientDto.setFooter(componentDto.getValue());
            } else if (componentDto.getId().equalsIgnoreCase("clientlogo")){
                clientDto.setLogo(componentDto.getValue());
            }
        });
        clientService.saveClientDetails(clientDto);
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            navigationItemDto.getWidgets().forEach(widgetDto -> {
                if(widgetDto.getId().equalsIgnoreCase("addnavigation")){
                    widgetDto.getComponentDtos().forEach(componentDto -> {
                        if (componentDto.getId().equalsIgnoreCase("clientid")){
                            componentDto.setValue(clientDto.getId());
                        }
                    });
                }
            });
        });

    }

}

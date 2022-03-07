package com.distarise.base.action;

import com.distarise.base.actionextension.LoadClientDetailsActionExt;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.ClientService;
import com.distarise.base.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadClientListAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private ClientService clientService;

    @Autowired
    private LoadClientDetailsActionExt loadClientDetailsActionExt;

    public static final String CONFIG_PAGE_DETAILS = "configPageDetailsDto";

    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("addclient")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("clientlist")){
                                List<ClientDto> clientDtoList = clientService.getAllClients();
                                List<ComponentItemDto> componentItemDtoList = targetComponentDto.getComponentItemDtos();
                                for (int i=0; i < clientDtoList.size(); i++){
                                    componentItemDtoList.add(new ComponentItemDto(13000L+i,
                                                    "clientlist", "distarise" , i+1,
                                            clientDtoList.get(i).getId(), clientDtoList.get(i).getHeader(), false, true
                                            )
                                    );
                                }
                                loadClientDetailsActionExt.preloadClientForm(request, targetWidgetDto, clientDtoList, request.getParameter("clientlist"));
                            }
                        });
                    }
                });
            }
        });

    }
}

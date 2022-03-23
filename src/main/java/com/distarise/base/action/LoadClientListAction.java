package com.distarise.base.action;

import com.distarise.base.actionextension.LoadClientDetailsActionExt;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        ConfigPageDetailsDto configPageDetailsDto = new ConfigPageDetailsDto();
        request.getSession().setAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS,configPageDetailsDto);
        String clientId = request.getParameter("clientlist");
        if (clientId == null){
            configPageDetailsDto.setClientId(getClientId());
        } else {
            configPageDetailsDto.setClientId(clientId);
        }
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("addclient")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("clientlist")){
                                List<ClientDto> clientDtoList = clientService.getAllClients();
                                List<ComponentItemDto> componentItemDtoList = targetComponentDto.getComponentItemDtos();
                                for (int i=0; i < clientDtoList.size(); i++){
                                    ComponentItemDto componentItemDto = new ComponentItemDto(13000L+i,
                                            "clientlist", "distarise" , i+1,
                                            clientDtoList.get(i).getId(), clientDtoList.get(i).getHeader(), false, true);
                                    if (clientDtoList.get(i).getId().equals(configPageDetailsDto.getClientId())){
                                        componentItemDto.setSelected(true);
                                    }
                                    componentItemDtoList.add(componentItemDto);
                                }
                                loadClientDetailsActionExt.preloadClientForm(request, targetWidgetDto, clientDtoList, configPageDetailsDto.getClientId());
                            }
                        });
                    }
                });
            }
        });

    }

}

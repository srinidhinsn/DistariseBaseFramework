package com.distarise.base.actionextension;

import com.distarise.base.action.LoadClientListAction;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.WidgetDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoadClientDetailsActionExt {

    public void preloadClientForm(HttpServletRequest request, WidgetDto targetWidgetDto,
                                  List<ClientDto> clientsList, String client) {
        if (null != client && !client.isEmpty() && !client.equalsIgnoreCase("new")){

            ClientDto clientToLoad = clientsList.stream().filter(
                    clientDto -> clientDto.getId().equals(client)).collect(Collectors.toList()).get(0);
            targetWidgetDto.getComponentDtos().forEach(componentDto -> {
                if (componentDto.getId().equals("clientname")){
                    componentDto.setValue(clientToLoad.getId());
                } else if (componentDto.getId().equals("clientheader")){
                    componentDto.setValue(clientToLoad.getHeader());
                } else if (componentDto.getId().equals("clientfooter")){
                    componentDto.setValue(clientToLoad.getFooter());
                } else if (componentDto.getId().equals("clientlogo")){
                    componentDto.setValue(clientToLoad.getLogo());
                } else if (componentDto.getId().equals("staticfolder")){
                    componentDto.setValue(clientToLoad.getStaticFolder());
                } else if (componentDto.getId().equals("clientlist")){
                    componentDto.getComponentItemDtos().forEach(componentItemDto -> {
                        if (componentItemDto.getValue().equals(client)){
                            componentItemDto.setSelected(true);
                        }
                    });
                }
            });

            ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto) request.getSession().
                    getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
            configPageDetailsDto.setClientId(clientToLoad.getId());
        }
    }
}

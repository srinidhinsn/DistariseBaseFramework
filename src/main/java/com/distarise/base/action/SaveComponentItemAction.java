package com.distarise.base.action;

import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.service.ComponentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveComponentItemAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private ComponentItemService componentItemService;

    public void executeAction(){
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto)
                request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        String clientId = configPageDetailsDto.getClientId();
        String componentId = configPageDetailsDto.getComponentId();
        String id = request.getParameter("column4");
        String editable = request.getParameter("column5");
        String label = request.getParameter("column6");
        String sortOrder = request.getParameter("column7");
        String value = request.getParameter("column8");
        String visible = request.getParameter("column9");
        String type = request.getParameter("column10");
        if (id != null && !id.isEmpty()){
            componentItemService.saveComponentItem(new ComponentItemDto(Long.parseLong(id), componentId, clientId,
                    Integer.parseInt(sortOrder), value, label, Boolean.parseBoolean(editable), Boolean.parseBoolean(visible), type));
        }
        else {
            componentItemService.saveComponentItem(new ComponentItemDto(componentId, clientId,
                    Integer.parseInt(sortOrder), value, label, Boolean.parseBoolean(editable), Boolean.parseBoolean(visible), type));
        }
    }
}

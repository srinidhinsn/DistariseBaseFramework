package com.distarise.base.action;

import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.service.ComponentItemService;
import com.distarise.base.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveComponentItemAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private ComponentItemService componentItemService;

    public void executeAction(){
        String clientId = request.getParameter("column2");
        String componentId = request.getParameter("column3");
        String id = request.getParameter("column4");
        String editable = request.getParameter("column5");
        String label = request.getParameter("column6");
        String sortOrder = request.getParameter("column7");
        String value = request.getParameter("column8");
        String visible = request.getParameter("column9");

        componentItemService.saveComponentItem(new ComponentItemDto(Long.parseLong(id), componentId, clientId,
                Integer.parseInt(sortOrder), value, label, Boolean.parseBoolean(editable), Boolean.parseBoolean(visible)));
    }
}

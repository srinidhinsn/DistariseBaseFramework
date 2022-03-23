package com.distarise.base.action;

import com.distarise.base.model.ComponentDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveComponentAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private ComponentService componentService;

    public void executeAction(){
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto)
                request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        String id = request.getParameter("column1");
        String editable = request.getParameter("column2");
        String label = request.getParameter("column3");
        String value = request.getParameter("column4");
        String keyOrAction = request.getParameter("column5");
        String redirectUrl = request.getParameter("column6");
        String sortOrder = request.getParameter("column7");
        String type = request.getParameter("column8");
        String widgetId = configPageDetailsDto.getWidgetId();
        String clientId = configPageDetailsDto.getClientId();
        Boolean visible = false;
        Boolean multiLevel = false;
        if (null != request.getParameter("column9")){
            visible = true;
        }
        if (null != request.getParameter("column10")){
            multiLevel = true;
        }

        componentService.saveComponent(new ComponentDto(id, widgetId, clientId, Integer.parseInt(sortOrder),
                type, label, true, keyOrAction, visible, value,
                multiLevel, redirectUrl, null, null, null));
    }
}

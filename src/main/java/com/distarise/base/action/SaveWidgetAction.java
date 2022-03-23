package com.distarise.base.action;

import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveWidgetAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private WidgetService widgetService;

    public void executeAction(){
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto)
                request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        String clientId = configPageDetailsDto.getClientId();
        String id = request.getParameter("column1");
        String title = request.getParameter("column2");
        String sortOrder = request.getParameter("column3");
        String redirectUrl = request.getParameter("column4");
        String navItemId = configPageDetailsDto.getNavItemId();
        String nestedWidgetId = request.getParameter("column6");
        String layoutId = request.getParameter("column7");
        String cssClass = request.getParameter("column8");
        String uiNavId = configPageDetailsDto.getUiNavId();

        WidgetDto widgetDto = new WidgetDto(id, clientId, navItemId, cssClass, title, layoutId,
                Integer.parseInt(sortOrder), nestedWidgetId, redirectUrl, null, null, null, null);
        widgetService.saveWidget(widgetDto);
    }
}

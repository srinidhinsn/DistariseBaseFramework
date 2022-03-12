package com.distarise.base.action;

import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.WidgetDto;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveWidgetAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private WidgetService widgetService;

    public void executeAction(){
        String id = request.getParameter("column2");
        String title = request.getParameter("column3");
        String sortOrder = request.getParameter("column4");
        String navItemId = request.getParameter("column5");
        String nestedWidgetId = request.getParameter("column6");
        String layoutId = request.getParameter("column7");
        String cssClass = request.getParameter("column8");
        String clientId = request.getParameter("column9");
        String uiNavId = request.getParameter("column10");
        String uiNavItemId = request.getParameter("column11");

        WidgetDto widgetDto = new WidgetDto(id, clientId, navItemId, cssClass, title, layoutId,
                Integer.parseInt(sortOrder), nestedWidgetId, null, null, null, null);
        widgetService.saveWidget(widgetDto);
    }
}

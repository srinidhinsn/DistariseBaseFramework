package com.distarise.base.action;

import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import javax.servlet.http.HttpServletRequest;

public interface BaseAction {
    void executeAction(HttpServletRequest httpServletRequest);
    void executeAction(PageDetailsDto pageDetailsDto);
    void executeAction(NavigationDto navigationDto);
    void executeAction(NavigationItemDto navigationItemDto);
    void executeAction(WidgetDto widgetDto);
}

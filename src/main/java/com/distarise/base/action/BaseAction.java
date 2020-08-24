package com.distarise.base.action;

import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;

import javax.servlet.http.HttpServletRequest;

public interface BaseAction {
    void executeAction(HttpServletRequest httpServletRequest);
    PageDetailsDto executeAction(PageDetailsDto pageDetailsDto);
    NavigationDto executeAction(NavigationDto navigationDto);
    NavigationItemDto executeAction(NavigationItemDto navigationItemDto);
    WidgetDto executeAction(WidgetDto widgetDto);
}

package com.distarise.base.action;

import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;

public interface BaseAction {
    public ObjectMapper oMapper = new ObjectMapper();
    public final static String WIDGET = "widgetDto";
    public final static String NAVIGATION = "navigationDto";
    public final static String PAGE_DETAILS = "pageDetailsDto";
    public final static String NAVIGATION_ITEM = "navigationItemDto";
    public final static String CHECKBOX_UNCHECKED = "UNCHECKED";
    public final static String CHECKBOX_CHECKED = "CHECKED";

    void executeAction();
    void executeAction(HttpServletRequest request);
}

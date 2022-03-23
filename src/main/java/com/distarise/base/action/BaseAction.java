package com.distarise.base.action;

import javax.servlet.http.HttpServletRequest;

public interface BaseAction {
    public final static String WIDGET = "widgetDto";
    public final static String NAVIGATION = "navigationDto";
    public final static String PAGE_DETAILS = "pageDetailsDto";
    public final static String NAVIGATION_ITEM = "navigationItemDto";
    public final static String CHECKBOX_UNCHECKED = "UNCHECKED";
    public final static String CHECKBOX_CHECKED = "CHECKED";
    public final static String DROPDOWN = "DROPDOWN";
    public final static String CHECKBOX = "CHECKBOX";

    void executeAction();
    void executeAction(HttpServletRequest request);
}

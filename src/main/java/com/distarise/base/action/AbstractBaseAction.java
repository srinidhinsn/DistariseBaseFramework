package com.distarise.base.action;

import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import javax.servlet.http.HttpServletRequest;

public class AbstractBaseAction implements BaseAction {
    HttpServletRequest request = null;

    @Override
    final public void executeAction(HttpServletRequest httpServletRequest){
        request = httpServletRequest;
    }

    @Override
    public void executeAction(PageDetailsDto pageDetailsDto){

    }

    @Override
    public void executeAction(NavigationDto navigationDto){

    }

    @Override
    public void executeAction(NavigationItemDto navigationItemDto){

    }

    @Override
    public void executeAction(WidgetDto widgetDto){

    }

}

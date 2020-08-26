package com.distarise.base.action;

import com.distarise.base.model.WidgetDto;
import org.springframework.stereotype.Service;

@Service
public class LoginAction extends AbstractBaseAction {

    @Override
    public void executeAction(){
        WidgetDto widgetDto = super.executeAction(new WidgetDto());
        System.out.println("ogin actin");
        request.setAttribute("widgetDto", widgetDto);
    }

}

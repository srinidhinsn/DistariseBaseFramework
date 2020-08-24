package com.distarise.base.action;

import com.distarise.base.model.WidgetDto;
import org.springframework.stereotype.Service;

@Service
public class LoginAction extends AbstractBaseAction {

    @Override
    public WidgetDto executeAction(WidgetDto widgetDto) {
        widgetDto = super.executeAction(widgetDto);
        System.out.println("ogin actin");
        return widgetDto;
    }
}

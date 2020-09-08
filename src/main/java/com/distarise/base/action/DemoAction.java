package com.distarise.base.action;

import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.model.WidgetDto;
import org.springframework.stereotype.Service;

@Service
public class DemoAction extends AbstractBaseAction implements BaseAction {

    @Override
    public void executeAction(){
        WidgetDto sourceWidgetDto = super.executeAction(new WidgetDto());
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("welcome")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            if(targetComponentDto.getId().equalsIgnoreCase("greetings") ||
                                    targetComponentDto.getId().equalsIgnoreCase("introduction")){
                                sourceWidgetDto.getComponentDtos().forEach(sourceComponentDto -> {
                                    if (sourceComponentDto.getId().equalsIgnoreCase("textareasample")){
                                        targetComponentDto.setValue(targetComponentDto.getValue()+" "+sourceComponentDto.getValue());
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });

    }

}

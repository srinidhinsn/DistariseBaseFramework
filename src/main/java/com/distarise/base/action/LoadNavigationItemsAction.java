package com.distarise.base.action;

import com.distarise.base.actionextension.LoadNavigationItemActionExt;
import com.distarise.base.actionextension.LoadNavigationsActionExt;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadNavigationItemsAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private LoadNavigationItemActionExt loadNavigationItemActionExt;

    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto)
                request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        String clientId = configPageDetailsDto.getClientDto().getId();
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("addnavigation") ||
                            targetWidgetDto.getId().equalsIgnoreCase("addwidget") ||
                            targetWidgetDto.getId().equalsIgnoreCase("addcomponent")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            //Loading Navigation items
                            if(targetComponentDto.getId().equalsIgnoreCase("landingpage")){
                                String selectedLandingPage = request.getParameter("landingpage");
                                List<ComponentItemDto> uiNavs = loadNavigationItemActionExt.preloadNavigationList(clientId, selectedLandingPage);
                                if (null!=uiNavs) {
                                    targetComponentDto.getComponentItemDtos().addAll(uiNavs);
                                }
                            } else if (targetComponentDto.getId().equalsIgnoreCase("navigationitemgrid")){
                                loadNavigationItemActionExt.preloadNavigationItemForm(request, clientId, targetComponentDto);
                            } else if (targetComponentDto.getId().equalsIgnoreCase("clientid")){
                                targetComponentDto.setValue(clientId);
                            }

                            //Loading widgets
                            else if (targetComponentDto.getId().equalsIgnoreCase("navigationitemlist")){
                                List<ComponentItemDto> uiNavItems = loadNavigationItemActionExt.preloadNavItemList(clientId, request);
                                if (null != uiNavItems){
                                    targetComponentDto.getComponentItemDtos().addAll(uiNavItems);
                                }
                            } else if (targetComponentDto.getId().equalsIgnoreCase("widgetsgrid")){
                                loadNavigationItemActionExt.preloadWidgetForm(request, clientId, targetComponentDto);
                            }

                            //Loading components
                            else if (targetComponentDto.getId().equalsIgnoreCase("widgetlist")){
                                List<ComponentItemDto> widgetList = loadNavigationItemActionExt.preloadWidgetList(clientId, request);
                                if (null != widgetList){
                                    targetComponentDto.getComponentItemDtos().addAll(widgetList);
                                }
                            } else if (targetComponentDto.getId().equalsIgnoreCase("componentgrid")){
                                loadNavigationItemActionExt.preloadComponentForm(request, clientId, targetComponentDto);
                            }
                        });
                    }
                });
            }
        });

    }
}

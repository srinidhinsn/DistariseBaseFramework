package com.distarise.base.action;

import com.distarise.base.actionextension.LoadNavigationItemActionExt;
import com.distarise.base.actionextension.LoadNavigationsActionExt;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class LoadNavigationItemsAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private LoadNavigationItemActionExt loadNavigationItemActionExt;

    public void executeAction(){
        PageDetailsDto targetPageDetailsDto = super.executeAction(new PageDetailsDto());
        ConfigPageDetailsDto configPageDetailsDto = setConfigPageDetails(request);
        String clientId = configPageDetailsDto.getClientId();
        targetPageDetailsDto.getNavigationDto().getNavigationItems().forEach(navigationItemDto -> {
            if (!navigationItemDto.getWidgets().isEmpty()){
                navigationItemDto.getWidgets().forEach(targetWidgetDto -> {
                    if (targetWidgetDto.getId().equalsIgnoreCase("addnavigationitem") ||
                            targetWidgetDto.getId().equalsIgnoreCase("addwidget") ||
                            targetWidgetDto.getId().equalsIgnoreCase("addcomponent") ||
                            targetWidgetDto.getId().equalsIgnoreCase("addcomponentitem")){
                        targetWidgetDto.getComponentDtos().forEach(targetComponentDto -> {
                            //Loading Navigation items
                            if(targetComponentDto.getId().equalsIgnoreCase("landingpage")){
                                List<ComponentItemDto> uiNavs = loadNavigationItemActionExt.preloadNavigationList(configPageDetailsDto);
                                if (null!=uiNavs) {
                                    targetComponentDto.getComponentItemDtos().addAll(uiNavs);
                                }
                            } else if (targetComponentDto.getId().equalsIgnoreCase("navigationitemgrid")){
                                loadNavigationItemActionExt.preloadNavigationItemForm(targetComponentDto, configPageDetailsDto);
                            } else if (targetComponentDto.getId().equalsIgnoreCase("clientid")){
                                targetComponentDto.setValue(configPageDetailsDto.getClientId());
                            }

                            //Loading widgets
                            else if (targetComponentDto.getId().equalsIgnoreCase("navigationitemlist")){
                                List<ComponentItemDto> uiNavItems = loadNavigationItemActionExt.preloadNavItemList(configPageDetailsDto);
                                if (null != uiNavItems){
                                    targetComponentDto.getComponentItemDtos().addAll(uiNavItems);
                                }
                            } else if (targetComponentDto.getId().equalsIgnoreCase("widgetsgrid")){
                                loadNavigationItemActionExt.preloadWidgetForm(targetComponentDto, configPageDetailsDto);
                            }

                            //Loading components
                            else if (targetComponentDto.getId().equalsIgnoreCase("widgetlist")){
                                List<ComponentItemDto> widgetList = loadNavigationItemActionExt.preloadWidgetList(configPageDetailsDto);
                                if (null != widgetList){
                                    targetComponentDto.getComponentItemDtos().addAll(widgetList);
                                }
                            } else if (targetComponentDto.getId().equalsIgnoreCase("componentgrid")){
                                loadNavigationItemActionExt.preloadComponentForm(targetComponentDto, configPageDetailsDto);
                            }

                            //Loading Component items
                            else if (targetComponentDto.getId().equalsIgnoreCase("componentlist")){
                                List<ComponentItemDto> componentList = loadNavigationItemActionExt.preloadComponentList(configPageDetailsDto);
                                if (null != componentList){
                                    targetComponentDto.getComponentItemDtos().addAll(componentList);
                                }
                            } else if (targetComponentDto.getId().equalsIgnoreCase("componentitemgrid")){
                                loadNavigationItemActionExt.preloadComponentItemForm(targetComponentDto, configPageDetailsDto);
                            }
                        });
                    }
                });
            }
        });

    }

    private ConfigPageDetailsDto setConfigPageDetails(HttpServletRequest request) {
        String selectedLandingPage = request.getParameter("landingpage");
        String selectedUiNavItem = request.getParameter("navigationitemlist");
        String selectedWidget = request.getParameter("widgetlist");
        String selectedComponent = request.getParameter("componentlist");
        ConfigPageDetailsDto configPageDetailsDto = (ConfigPageDetailsDto)
                request.getSession().getAttribute(LoadClientListAction.CONFIG_PAGE_DETAILS);
        if (null != selectedLandingPage){
            configPageDetailsDto.setUiNavId(selectedLandingPage);
        }
        if (null != selectedUiNavItem){
            configPageDetailsDto.setNavItemId(selectedUiNavItem);
        }
        if (null !=selectedWidget){
            configPageDetailsDto.setWidgetId(selectedWidget);
        }
        if (null != selectedComponent){
            configPageDetailsDto.setComponentId(selectedComponent);
        }

        return configPageDetailsDto;
    }
}

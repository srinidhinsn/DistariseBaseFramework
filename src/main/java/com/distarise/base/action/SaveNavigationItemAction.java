package com.distarise.base.action;

import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.NavigationItemDto;
import com.distarise.base.service.NavigationItemService;
import com.distarise.base.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveNavigationItemAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private NavigationItemService navigationItemService;

    public void executeAction(){
        String id = request.getParameter("column2");
        String navName = request.getParameter("column3");
        String sortOrder = request.getParameter("column4");
        String url = request.getParameter("column5");
        String layoutId = request.getParameter("column6");
        String navItemId = request.getParameter("column7");
        String clientId = request.getParameter("column8");
        String uiNavId = request.getParameter("column9");
        NavigationItemDto navigationItemDto = new NavigationItemDto(id, uiNavId, clientId, navName, url,
                Integer.parseInt(sortOrder), layoutId, navItemId, null, null);

        navigationItemService.saveNavigationItem(navigationItemDto);
    }
}

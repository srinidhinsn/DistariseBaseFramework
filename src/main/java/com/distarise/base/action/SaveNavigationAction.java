package com.distarise.base.action;

import com.distarise.base.actionextension.LoadNavigationsActionExt;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.NavigationDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveNavigationAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private NavigationService navigationService;

    public void executeAction(){
        String id = request.getParameter("column2");
        String module = request.getParameter("column3");
        String pageDescription = request.getParameter("column4");
        String pageName = request.getParameter("column5");
        String pageTitle = request.getParameter("column6");
        String redirectPageName = request.getParameter("column7");
        String role = request.getParameter("column8");
        String clientId = request.getParameter("column1");
        NavigationDto navigationDto = new NavigationDto(id, clientId, role, pageTitle,
                pageDescription, module, pageName, redirectPageName, "", null);

        navigationService.saveNavigationDetails(navigationDto);

    }
}

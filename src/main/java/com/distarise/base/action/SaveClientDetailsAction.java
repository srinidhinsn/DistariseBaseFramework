package com.distarise.base.action;

import com.distarise.base.actionextension.LoadClientDetailsActionExt;
import com.distarise.base.model.ClientDto;
import com.distarise.base.model.ComponentItemDto;
import com.distarise.base.model.ConfigPageDetailsDto;
import com.distarise.base.model.PageDetailsDto;
import com.distarise.base.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveClientDetailsAction extends AbstractBaseAction implements BaseAction {

    @Autowired
    private ClientService clientService;

    public void executeAction() {
        String clientId = request.getParameter("clientname");
        String header = request.getParameter("clientheader");
        String footer = request.getParameter("clientfooter");
        String logo = request.getParameter("clientlogo");
        ClientDto clientDto = new ClientDto(clientId, header, footer, logo);
        clientService.saveClientDetails(clientDto);
    }
}

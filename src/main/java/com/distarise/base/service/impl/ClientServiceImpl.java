package com.distarise.base.service.impl;

import com.distarise.base.dao.ClientDao;
import com.distarise.base.model.ClientDto;
import com.distarise.base.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao clientDao;

    @Override
    public ClientDto getClientDetails(String clientId){
        ClientDto clientDto = clientDao.getClientDetails(clientId);
        return clientDto;
    }
}

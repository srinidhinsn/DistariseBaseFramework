package com.distarise.base.dao.impl;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.dao.ClientDao;
import com.distarise.base.entity.Client;
import com.distarise.base.model.ClientDto;
import com.distarise.base.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientDaoImpl implements ClientDao, AbstractBaseDao {

    private static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDto getClientDetails(String clientId){
        logger.debug("Client id :"+clientId);
        Client client = clientRepository.getClientDetails(clientId);
        return modelMapper.map(client, ClientDto.class);
    }
}

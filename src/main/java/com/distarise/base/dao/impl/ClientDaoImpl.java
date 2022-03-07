package com.distarise.base.dao.impl;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.dao.ClientDao;
import com.distarise.base.entity.Client;
import com.distarise.base.model.ClientDto;
import com.distarise.base.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientDaoImpl implements ClientDao, AbstractBaseDao {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDto getClientDetails(String clientId){
        Client client = clientRepository.findOne(clientId);
        return modelMapper.map(client, ClientDto.class);
    }

    @Override
    public ClientDto saveClientDetails(ClientDto clientDto){
        Client client = modelMapper.map(clientDto, Client.class);
        clientRepository.save(client);
        return clientDto;
    }

    @Override
    public List<ClientDto> getAllClients(){
        List<ClientDto> clientDtoList = new ArrayList<>();
        List<Client> clientList = (List<Client>) clientRepository.findAll();
        clientList.forEach(client -> {
            clientDtoList.add(modelMapper.map(client, ClientDto.class));
        });
        return clientDtoList;
    }
}

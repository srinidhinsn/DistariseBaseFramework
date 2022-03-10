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
import java.util.stream.Collectors;

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
        List<Client> clientList = (List<Client>) clientRepository.findAll();
        return convertEntityListToDtoList(clientList);
    }

    private List<ClientDto> convertEntityListToDtoList(List<Client> clientList){
        return clientList.stream().map(client -> (modelMapper.map(client, ClientDto.class))).collect(Collectors.toList());
    }
}

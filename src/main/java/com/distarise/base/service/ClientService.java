package com.distarise.base.service;

import com.distarise.base.model.ClientDto;

import java.util.List;

public interface ClientService extends AbstractBaseService {
    ClientDto getClientDetails(String clientId);
    ClientDto saveClientDetails(ClientDto clientDto);
    List<ClientDto> getAllClients();
    void deleteClient(ClientDto clientDto);
}

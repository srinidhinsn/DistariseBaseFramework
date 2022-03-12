package com.distarise.base.dao;

import com.distarise.base.model.ClientDto;

import java.util.List;

public interface ClientDao extends AbstractBaseDao {
    ClientDto getClientDetails(String clientId);
    ClientDto saveClientDetails(ClientDto clientDto);
    List<ClientDto> getAllClients();
    void deleteClient(ClientDto clientDto);
}

package com.distarise.base.dao;

import com.distarise.base.model.ClientDto;

public interface ClientDao extends AbstractBaseDao {
    ClientDto getClientDetails(String clientId);
    ClientDto saveClientDetails(ClientDto clientDto);
}

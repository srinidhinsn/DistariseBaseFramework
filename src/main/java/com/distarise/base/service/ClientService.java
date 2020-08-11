package com.distarise.base.service;

import com.distarise.base.model.ClientDto;

public interface ClientService extends AbstractBaseService {
    ClientDto getClientDetails(String clientId);
}

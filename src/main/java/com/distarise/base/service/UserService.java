package com.distarise.base.service;

import com.distarise.base.model.UserDetailsDto;

public interface UserService extends AbstractBaseService {
    UserDetailsDto getUserDetails(String userId, String password);

}

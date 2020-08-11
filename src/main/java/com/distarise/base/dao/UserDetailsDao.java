package com.distarise.base.dao;

import com.distarise.base.model.UserDetailsDto;

public interface UserDetailsDao extends AbstractBaseDao {
    UserDetailsDto getUserDetails(String userId, String password);
}

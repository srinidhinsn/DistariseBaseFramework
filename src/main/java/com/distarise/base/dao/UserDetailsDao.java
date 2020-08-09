package com.distarise.base.dao;

import com.distarise.base.model.UserDetailsDto;

public interface UserDetailsDao {
    UserDetailsDto getUserDetails(String userId, String password);
}

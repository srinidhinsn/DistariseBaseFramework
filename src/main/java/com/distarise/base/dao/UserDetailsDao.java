package com.distarise.base.dao;

import com.distarise.base.model.UserDetailsDto;

public interface UserDetailsDao extends BaseDao{
    UserDetailsDto getUserDetails(String userId, String password);

}

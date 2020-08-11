package com.distarise.base.service.impl;

import com.distarise.base.dao.UserDetailsDao;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDetailsDao userDetailsDao;

    @Autowired
    BaseService baseService;

    @Override
    public UserDetailsDto getUserDetails(String userId, String password) {
        return userDetailsDao.getUserDetails(userId, password);
    }


}

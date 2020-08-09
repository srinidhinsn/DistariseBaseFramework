package com.distarise.base.service;

import com.distarise.base.dao.UserDetailsDao;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.repository.UserDetailsRepository;
import com.distarise.base.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDetailsDao userDetailsDao;

    @Override
    public UserDetailsDto getUserDetails(String userId, String password) {
        return userDetailsDao.getUserDetails(userId, password);
    }
}

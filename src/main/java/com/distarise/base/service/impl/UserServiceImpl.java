package com.distarise.base.service.impl;

import com.distarise.base.dao.UserDetailsDao;
import com.distarise.base.dao.UserRoleDao;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.UserRoleDto;
import com.distarise.base.service.BaseService;
import com.distarise.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDetailsDao userDetailsDao;

    @Autowired
    BaseService baseService;

    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public UserDetailsDto getUserDetails(String userId, String password, String clientId) {
        return userDetailsDao.getUserDetails(userId, password, clientId);
    }

    @Override
    public List<UserRoleDto> getUserRoles(String userId, String clientId) {
        return userDetailsDao.getUserRoles(userId, clientId);
    }

    @Override
    public List<RoleWidgetActionDto> getUserRoleWidgetActions(String userId, String clientId){
        return userRoleDao.getUserRoleWidgetActions(userId, clientId);
    }

}

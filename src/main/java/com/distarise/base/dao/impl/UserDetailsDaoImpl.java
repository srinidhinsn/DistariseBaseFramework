package com.distarise.base.dao.impl;

import com.distarise.base.dao.UserDetailsDao;
import com.distarise.base.entity.UserDetails;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetailsDto getUserDetails(String userId, String password) {
        UserDetails userDetails = userDetailsRepository.getUserDetails(userId, password);
        return modelMapper.map(userDetails, UserDetailsDto.class);
    }

}

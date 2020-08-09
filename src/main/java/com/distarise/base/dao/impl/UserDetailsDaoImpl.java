package com.distarise.base.dao.impl;

import com.distarise.base.dao.UserDetailsDao;
import com.distarise.base.entity.UserDetails;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.repository.UserDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserDetailsDto getUserDetails(String userId, String password) {
        if (userId != null) {
            UserDetails userDetails = userDetailsRepository.findUserDetails(userId);
            UserDetails userDetails2 = userDetailsRepository.findUserDetailsByUserId(userId);
            System.out.println("Userdetails2  - "+userDetails2.getPassword());
            return modelMapper.map(userDetails, UserDetailsDto.class);
        } return new UserDetailsDto();
    }


}

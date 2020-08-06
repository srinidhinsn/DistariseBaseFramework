package com.distarise.base.service;

import com.distarise.base.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDetailsRepository userRepository;
}

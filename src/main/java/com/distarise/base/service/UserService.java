package com.distarise.base.service;

import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDetailsDto getUserDetails(String userId, String password);
}

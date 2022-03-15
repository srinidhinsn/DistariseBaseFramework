package com.distarise.base.dao.impl;

import com.distarise.base.dao.UserDetailsDao;
import com.distarise.base.dao.UserRoleDao;
import com.distarise.base.entity.UserDetails;
import com.distarise.base.entity.UserRole;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.UserRoleDto;
import com.distarise.base.repository.UserDetailsRepository;
import com.distarise.base.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserRoleDao userRoleDao;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetailsDto getUserDetails(String userId, String password, String clientId) {
        UserDetails userDetails = userDetailsRepository.getUserDetails(userId, password, clientId);
        UserDetailsDto userDetailsDto = null;
        if (null != userDetails){
            List<UserRoleDto> userRoleDtoList = getUserRoles(userId, clientId);
            List<RoleWidgetActionDto> roleWidgetActionDtoList = userRoleDao.getUserRoleWidgetActions(userId, clientId);
            userDetailsDto = modelMapper.map(userDetails, UserDetailsDto.class);
            userDetailsDto.setRoleName(userRoleDtoList.get(0).getRoleName());
            userDetailsDto.setRoleAccessList(roleWidgetActionDtoList);
        }

        return userDetailsDto;
    }

    @Override
    public List<UserRoleDto> getUserRoles(String userId, String clientId){
        List<UserRole> userRoles = userRoleRepository.getUserRole(userId, clientId);
        return userRoles.stream().map(
                userRole -> modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UserDetailsDto> getAllUserByClientId(String clientId) {
        List<UserDetails> userDetailsList = userDetailsRepository.getAllUserByClientId(clientId);
        return convertEntityListToDtoList(userDetailsList);
    }

    private List<UserDetailsDto> convertEntityListToDtoList(List<UserDetails> userDetailsList) {
        return userDetailsList.stream().map(userDetails ->
                modelMapper.map(userDetails, UserDetailsDto.class)).collect(Collectors.toList());
    }

    @Override
    public void saveUserDetails(UserDetailsDto userDetailsDto) {
        userDetailsRepository.save(modelMapper.map(userDetailsDto, UserDetails.class));
    }
}

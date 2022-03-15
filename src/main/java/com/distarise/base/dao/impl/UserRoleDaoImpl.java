package com.distarise.base.dao.impl;

import com.distarise.base.dao.UserRoleDao;
import com.distarise.base.entity.RoleWidgetAction;
import com.distarise.base.entity.UserRole;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.model.UserDetailsDto;
import com.distarise.base.model.UserRoleDto;
import com.distarise.base.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public List<RoleWidgetActionDto> getUserRoleWidgetActions(String userId, String clientId){
        List<RoleWidgetAction> roleWidgetActionList= userRoleRepository.getUserRoleWidgetActions(userId, clientId);
        List<RoleWidgetActionDto> roleWidgetActionDtoList = roleWidgetActionList.stream().
                map(roleWidgetAction -> modelMapper.map(roleWidgetAction, RoleWidgetActionDto.class)).
                collect(Collectors.toList());
        return roleWidgetActionDtoList;
    }

    @Override
    public List<UserRoleDto> getAllUserRolesByClientId(String clientId) {
        List<UserRole> userRoleList = userRoleRepository.getAllUserRolesByClientId(clientId);
        return convertEntityListToDtoList(userRoleList);
    }

    private List<UserRoleDto> convertEntityListToDtoList(List<UserRole> userRoleList){
        return userRoleList.stream().map(userRole->
                modelMapper.map(userRole, UserRoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public void saveUserRoleDetails(UserDetailsDto userDetailsDto) {
        userRoleRepository.save(modelMapper.map(userDetailsDto, UserRole.class));
    }
}

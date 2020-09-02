package com.distarise.base.dao.impl;

import com.distarise.base.dao.UserRoleDao;
import com.distarise.base.entity.RoleWidgetAction;
import com.distarise.base.model.RoleWidgetActionDto;
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

}

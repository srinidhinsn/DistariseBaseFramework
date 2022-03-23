package com.distarise.base.dao.impl;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.dao.RoleDao;
import com.distarise.base.entity.Role;
import com.distarise.base.entity.RoleWidgetAction;
import com.distarise.base.model.RoleDto;
import com.distarise.base.model.RoleWidgetActionDto;
import com.distarise.base.repository.RoleRepository;
import com.distarise.base.repository.RoleWidgetActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleDaoImpl implements RoleDao, AbstractBaseDao {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleWidgetActionRepository roleWidgetActionRepository;

    @Override
    public List<RoleDto> getRoleList(String client) {
        List<Role> roleList = roleRepository.findByClientId(client);
        return convertEntityToDtoList(roleList);
    }

    @Override
    public void saveRole(RoleDto roleDto) {
        roleRepository.save(modelMapper.map(roleDto, Role.class));
    }

    private List<RoleDto> convertEntityToDtoList(List<Role> roleList){
        return  roleList.stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
    }

    @Override
    public void saveRoleWidgetAction(RoleWidgetActionDto roleWidgetActionDto) {
        roleWidgetActionRepository.save(modelMapper.map(roleWidgetActionDto, RoleWidgetAction.class));
    }

    @Override
    public List<RoleWidgetActionDto> findAllByClientId(String clientId) {
        List<RoleWidgetAction> roleWidgetActionList = roleWidgetActionRepository.findAllByClientId(clientId);
        return roleWidgetActionList.stream().map(roleWidgetAction ->
                modelMapper.map(roleWidgetAction, RoleWidgetActionDto.class)).collect(Collectors.toList());
    }


}

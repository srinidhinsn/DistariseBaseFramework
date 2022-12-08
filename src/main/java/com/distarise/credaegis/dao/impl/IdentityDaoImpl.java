package com.distarise.credaegis.dao.impl;

import com.distarise.credaegis.dao.IdentityDao;
import com.distarise.credaegis.dao.LeadDao;
import com.distarise.credaegis.entity.Identity;
import com.distarise.credaegis.entity.Lead;
import com.distarise.credaegis.model.IdentityDto;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.repository.IdentityRepository;
import com.distarise.credaegis.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IdentityDaoImpl implements IdentityDao {

    @Autowired
    IdentityRepository identityRepository;

    @Override
    public void save(List<IdentityDto> identityDtoList) {
        List<Identity> identityList = identityDtoList.stream().
                map(identityDto -> modelMapper.map(identityDto, Identity.class)).toList();
        identityRepository.saveAll(identityList);
    }

    @Override
    public IdentityDto save(IdentityDto identityDto) {
        Identity identity = modelMapper.map(identityDto, Identity.class);
        identityDto.setId(identity.getId());
        return identityDto;
    }
}

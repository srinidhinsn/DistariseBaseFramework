package com.distarise.credaegis.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.credaegis.model.IdentityDto;
import com.distarise.credaegis.model.LeadDto;

import java.util.List;

public interface IdentityDao extends AbstractBaseDao {
    void save(List<IdentityDto> identityDtoList);
    IdentityDto save(IdentityDto identityDto);
}

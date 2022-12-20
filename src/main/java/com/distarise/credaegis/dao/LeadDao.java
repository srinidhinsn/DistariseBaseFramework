package com.distarise.credaegis.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.credaegis.model.LeadDto;

import java.util.List;

public interface LeadDao extends AbstractBaseDao {
    void save(List<LeadDto> leadDtoList);
    void save(LeadDto leadDto);
    void delete(Long id);

    LeadDto getLeadById(Long id);
}

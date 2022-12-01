package com.distarise.credaegis.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.credaegis.model.CaseDto;

import java.util.List;

public interface CaseDao extends AbstractBaseDao {
    void save(List<CaseDto> caseDtoList);
    void save(CaseDto caseDto);
}

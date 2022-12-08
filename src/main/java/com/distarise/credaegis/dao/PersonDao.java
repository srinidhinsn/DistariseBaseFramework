package com.distarise.credaegis.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.credaegis.model.PersonDto;

public interface PersonDao extends AbstractBaseDao {
    PersonDto save(PersonDto personDto);
    PersonDto findByPid(Long pid);
}

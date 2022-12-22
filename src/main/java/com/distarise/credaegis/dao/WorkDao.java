package com.distarise.credaegis.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.WorkDto;

import java.util.List;

public interface WorkDao extends AbstractBaseDao {
    void save(List<WorkDto> workDtoList);
    void save(WorkDto workDto);
    List<WorkDto> getWorkByStatus(String status);

    List<WorkDto> getWorkByPid(Long pid);
}

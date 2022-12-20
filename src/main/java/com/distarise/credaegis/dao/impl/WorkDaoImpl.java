package com.distarise.credaegis.dao.impl;

import com.distarise.credaegis.dao.WorkDao;
import com.distarise.credaegis.entity.Lead;
import com.distarise.credaegis.entity.Work;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.model.WorkDto;
import com.distarise.credaegis.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkDaoImpl implements WorkDao {

    @Autowired
    WorkRepository workRepository;

    @Override
    public void save(List<WorkDto> workDtoList) {
        List<Work> workList = workDtoList.stream().
                map(workDto -> modelMapper.map(workDto, Work.class)).toList();
        workRepository.saveAll(workList);
    }

    @Override
    public void save(WorkDto workDto) {
        Work work = modelMapper.map(workDto, Work.class);
        workRepository.save(work);
    }

    @Override
    public List<WorkDto> getWorkByStatus(String status) {
        List<Work> workList = workRepository.findByStatusOrderByPidDesc(status);
        return workList.stream().map(work -> modelMapper.map(work, WorkDto.class)).toList();
    }
}

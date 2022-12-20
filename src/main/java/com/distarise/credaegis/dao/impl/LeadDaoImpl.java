package com.distarise.credaegis.dao.impl;

import com.distarise.credaegis.dao.LeadDao;
import com.distarise.credaegis.entity.Lead;
import com.distarise.credaegis.model.LeadDto;
import com.distarise.credaegis.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeadDaoImpl implements LeadDao {

    @Autowired
    LeadRepository leadRepository;

    @Override
    public void save(List<LeadDto> leadDtoList) {
        List<Lead> leadList = leadDtoList.stream().
                map(leadDto -> modelMapper.map(leadDto, Lead.class)).toList();
        leadRepository.saveAll(leadList);
    }

    @Override
    public void save(LeadDto leadDto) {
        leadRepository.save(modelMapper.map(leadDto, Lead.class));
    }

    public LeadDto getLeadById(Long id){
        return modelMapper.map(leadRepository.findById(id).get(), LeadDto.class);
    }
    @Override
    public void delete(Long id) {
        leadRepository.deleteById(id);
    }
}

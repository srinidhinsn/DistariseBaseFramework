package com.distarise.credaegis.dao.impl;

import com.distarise.credaegis.dao.CaseDao;
import com.distarise.credaegis.entity.Case;
import com.distarise.credaegis.model.CaseDto;
import com.distarise.credaegis.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CaseDaoImpl implements CaseDao {

    @Autowired
    CaseRepository caseRepository;

    @Override
    public void save(List<CaseDto> caseDtoList) {
        List<Case> caseList = caseDtoList.stream().
                map(caseDto -> modelMapper.map(caseDto, Case.class)).toList();
        caseRepository.saveAll(caseList);
    }

    @Override
    public void save(CaseDto caseDto) {
        
    }
}

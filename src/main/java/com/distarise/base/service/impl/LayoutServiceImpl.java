package com.distarise.base.service.impl;

import com.distarise.base.dao.LayoutDao;
import com.distarise.base.model.LayoutDto;
import com.distarise.base.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LayoutServiceImpl implements LayoutService {

    @Autowired
    LayoutDao layoutDao;

    public Map<String, LayoutDto> getAllLayoutDesigns(){
        List<LayoutDto> layoutDtoList = layoutDao.getAllLayoutDesigns();
        Map<String, LayoutDto> layoutDtoMap = layoutDtoList.stream().
                collect(Collectors.toMap(LayoutDto::getId, layoutDto -> layoutDto));
        return layoutDtoMap;
    }
}

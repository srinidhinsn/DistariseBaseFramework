package com.distarise.base.dao.impl;

import com.distarise.base.dao.LayoutDao;
import com.distarise.base.entity.Layout;
import com.distarise.base.model.LayoutDto;
import com.distarise.base.repository.LayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LayoutDaoImpl implements LayoutDao {

    @Autowired
    LayoutRepository layoutRepository;

    public LayoutDto getLayoutDetails(String id){
        Layout layout = layoutRepository.getLayoutDetails(id);
        return modelMapper.map(layout, LayoutDto.class);
    }
}

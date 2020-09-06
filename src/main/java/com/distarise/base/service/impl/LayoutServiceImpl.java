package com.distarise.base.service.impl;

import com.distarise.base.dao.LayoutDao;
import com.distarise.base.model.LayoutDto;
import com.distarise.base.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;

public class LayoutServiceImpl implements LayoutService {

    @Autowired
    LayoutDao layoutDao;

    public LayoutDto getLayoutDetails(String id){
        return layoutDao.getLayoutDetails(id);
    }
}

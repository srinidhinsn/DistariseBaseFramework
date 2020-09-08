package com.distarise.base.dao.impl;

import com.distarise.base.dao.LayoutDao;
import com.distarise.base.entity.Layout;
import com.distarise.base.model.LayoutDto;
import com.distarise.base.repository.LayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LayoutDaoImpl implements LayoutDao {

    @Autowired
    LayoutRepository layoutRepository;

    @Override
    public List<LayoutDto> getAllLayoutDesigns() {
        List<Layout> layoutList = layoutRepository.getLayoutDetails();
        return layoutList.stream().map(layout -> modelMapper.map
                (layout, LayoutDto.class)).collect(Collectors.toList());
    }
}

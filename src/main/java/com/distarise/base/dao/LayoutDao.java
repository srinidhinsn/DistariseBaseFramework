package com.distarise.base.dao;

import com.distarise.base.model.LayoutDto;

import java.util.List;

public interface LayoutDao extends AbstractBaseDao {
    List<LayoutDto> getAllLayoutDesigns();
}

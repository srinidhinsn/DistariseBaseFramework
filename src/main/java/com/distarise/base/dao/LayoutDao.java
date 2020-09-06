package com.distarise.base.dao;

import com.distarise.base.model.LayoutDto;

public interface LayoutDao extends AbstractBaseDao {
    LayoutDto getLayoutDetails(String id);
}

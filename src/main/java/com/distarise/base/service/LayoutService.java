package com.distarise.base.service;

import com.distarise.base.model.LayoutDto;

public interface LayoutService extends AbstractBaseService {
    LayoutDto getLayoutDetails(String id);
}

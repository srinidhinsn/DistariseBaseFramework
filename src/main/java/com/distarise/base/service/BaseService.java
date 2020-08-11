package com.distarise.base.service;

import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.PageDetailsDto;

public interface BaseService extends AbstractBaseService {
    PageDetailsDto getPageDetails(BaseContextDto baseContextDto);
}

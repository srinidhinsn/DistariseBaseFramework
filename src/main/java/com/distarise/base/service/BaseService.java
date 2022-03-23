package com.distarise.base.service;

import com.distarise.base.model.BaseContextDto;
import com.distarise.base.model.PageDetailsDto;

import javax.servlet.http.HttpServletRequest;

public interface BaseService extends AbstractBaseService {
    public static final String AUTO_ACTION = "autoaction";
    PageDetailsDto getPageDetails(BaseContextDto baseContextDto);
    void preloadWidgets(HttpServletRequest request, PageDetailsDto pageDetailsDto, BaseContextDto baseContextDto);
}

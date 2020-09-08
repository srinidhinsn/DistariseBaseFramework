package com.distarise.base.service;

import com.distarise.base.model.LayoutDto;

import java.util.Map;

public interface LayoutService extends AbstractBaseService {
    Map<String, LayoutDto> getAllLayoutDesigns();
}

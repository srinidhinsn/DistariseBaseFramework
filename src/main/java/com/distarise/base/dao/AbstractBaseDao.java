package com.distarise.base.dao;

import org.modelmapper.ModelMapper;

public interface AbstractBaseDao {
    ModelMapper modelMapper = new ModelMapper();
}

package com.distarise.base.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;

public interface AbstractBaseService {
    ModelMapper modelMapper = new ModelMapper();
    ObjectMapper oMapper = new ObjectMapper();
}

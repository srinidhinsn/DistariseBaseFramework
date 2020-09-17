package com.distarise.base.dao.amruthhani;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.model.amruthhani.ProductDto;

import java.util.List;

public interface ProductDao extends AbstractBaseDao {
    List<ProductDto> findAll();
    ProductDto findById(String id);
}

package com.distarise.ecommerce.dao;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.ecommerce.model.ProductDto;

import java.util.List;

public interface ProductDao extends AbstractBaseDao {
    List<ProductDto> findAll();
    ProductDto findById(String id);
}

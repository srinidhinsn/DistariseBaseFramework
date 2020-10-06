package com.distarise.base.dao.ecommerce;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.model.ecommerce.ProductDto;

import java.util.List;

public interface ProductDao extends AbstractBaseDao {
    List<ProductDto> findAll();
    ProductDto findById(String id);
}

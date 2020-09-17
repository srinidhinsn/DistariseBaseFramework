package com.distarise.base.service.amruthhani;

import com.distarise.base.model.amruthhani.ProductDto;
import com.distarise.base.service.AbstractBaseService;

import java.util.List;
import java.util.Map;

public interface ProductService extends AbstractBaseService {
    List<ProductDto> findAll();
    ProductDto findById(String id);
    List<Map<String, String>> covertProductsToMap(List<ProductDto> productList,
                                                  List<Map<String, String>> productMap);
}

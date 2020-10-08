package com.distarise.ecommerce.service.impl;

import com.distarise.ecommerce.dao.ProductDao;
import com.distarise.ecommerce.model.ProductDto;
import com.distarise.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<ProductDto> findAll(){
        return productDao.findAll();
    }


    @Override
    public ProductDto findById(String id){
        return productDao.findById(id);
    }

    @Override
    public List<Map<String, String>> covertProductsToMap(List<ProductDto> productList,
                                                  List<Map<String, String>> productMap){

        return null;
    }
}

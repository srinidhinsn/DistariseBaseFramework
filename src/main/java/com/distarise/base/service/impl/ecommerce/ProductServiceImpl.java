package com.distarise.base.service.impl.ecommerce;

import com.distarise.base.dao.ecommerce.ProductDao;
import com.distarise.base.model.ecommerce.ProductDto;
import com.distarise.base.service.ecommerce.ProductService;
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

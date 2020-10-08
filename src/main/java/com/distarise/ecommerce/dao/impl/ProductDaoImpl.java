package com.distarise.ecommerce.dao.impl;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.ecommerce.dao.ProductDao;
import com.distarise.ecommerce.entity.Product;
import com.distarise.ecommerce.model.ProductDto;
import com.distarise.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDaoImpl implements AbstractBaseDao, ProductDao {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDto> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(String id){
        Product product = productRepository.findById(id);
        return modelMapper.map(product, ProductDto.class);
    }

}

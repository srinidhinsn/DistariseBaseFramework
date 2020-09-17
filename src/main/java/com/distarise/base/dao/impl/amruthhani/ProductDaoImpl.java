package com.distarise.base.dao.impl.amruthhani;

import com.distarise.base.dao.AbstractBaseDao;
import com.distarise.base.dao.amruthhani.ProductDao;
import com.distarise.base.entity.amruthhani.Product;
import com.distarise.base.model.amruthhani.ProductDto;
import com.distarise.base.repository.amruthhani.ProductRepository;
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

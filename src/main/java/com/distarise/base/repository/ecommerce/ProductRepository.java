package com.distarise.base.repository.ecommerce;

import com.distarise.base.entity.ecommerce.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findAll();
    Product findById(String id);
}

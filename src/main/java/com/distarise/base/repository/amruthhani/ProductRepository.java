package com.distarise.base.repository.amruthhani;

import com.distarise.base.entity.Client;
import com.distarise.base.entity.amruthhani.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findAll();
    Product findById(String id);
}

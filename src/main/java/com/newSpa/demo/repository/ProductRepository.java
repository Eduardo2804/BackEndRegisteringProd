package com.newSpa.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.newSpa.demo.model.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Integer> {
    
}

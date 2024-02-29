package com.example_put.demo_put.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.JpaRepository;+
import org.springframework.stereotype.Repository;

import com.example_put.demo_put.model.ProductModel;
@Repository
public interface ProductRepository extends JpaRepository <ProductModel, Integer>{
    
}

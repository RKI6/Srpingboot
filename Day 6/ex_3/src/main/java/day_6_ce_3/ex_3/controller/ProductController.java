package day_6_ce_3.ex_3.controller;

// package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import day_6_ce_3.ex_3.model.Product;
import day_6_ce_3.ex_3.service.ProductService;



@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/api/product")
    public ResponseEntity<Product> postProduct(@RequestBody Product product)
    {
        if(productService.post(product) == true)
        return new ResponseEntity<>(product , HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/product/{offset}/{pageSize}")
    public ResponseEntity<List<Product>> getPage(@PathVariable int offset , @PathVariable int pageSize)
    {
        return new ResponseEntity<>( productService.getPage(offset, pageSize), HttpStatus.OK);
    }
    @GetMapping("/api/product/{offset}/{pageSize}/{field}")
    public ResponseEntity<List<Product>> getPage(@PathVariable int offset , @PathVariable int pageSize , @PathVariable String field)
    {
        return new ResponseEntity<>(productService.getSortedPage(offset, pageSize,field) , HttpStatus.OK);
    }
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId)
    {
        Product product = productService.getById(productId);
        if(product != null)
        return new ResponseEntity<>(product , HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


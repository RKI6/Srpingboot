package com.example_put.demo_put.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example_put.demo_put.model.ProductModel;
import com.example_put.demo_put.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService  = productService;
    }
    public ProductController ()
    {

    }
    @PostMapping("/product")
    public ResponseEntity<ProductModel>postProduct(@RequestBody ProductModel productModel)
    {
        if(productService.saveProduct(productModel) == true)
        {
            return new ResponseEntity<>(productModel,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(productModel,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // @GetMapping("/product/{id}")
    // public ResponseEntity<ProductModel>getProduct(@PathVariable("id") Integer productId)
    // {
    //    ProductModel productModel = productService.getProduct(productId);
    //    if (productModel == null)
    //    return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    //    return new ResponseEntity<>(productModel,HttpStatus.FOUND);
    // }
    @GetMapping("/all")
    public ResponseEntity<List<ProductModel>>getProducts()
    {
        List<ProductModel>list = productService.getAllProduct();
        if(list.isEmpty())
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
            // return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<ProductModel> putMethodName(@PathVariable int id, @RequestBody ProductModel productModel) {
        if (productService.updateProduct(id , productModel) == true){

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductModel> deleteProduct(@PathVariable Integer id)
    {
        if(productService.deleteProduct(id) == true)
        return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/page/{offset}/{pageSize}/{field}")
    public Page<ProductModel> getMethodName(@PathVariable int offset ,@PathVariable int pageSize ,@PathVariable String field) {
        return productService.producPage(offset, pageSize, field);
    }
    
}

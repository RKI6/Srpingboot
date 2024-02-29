package com.example_put.demo_put.service;

import java.util.List;
import java.util.Optional;

// import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example_put.demo_put.model.ProductModel;
import com.example_put.demo_put.repository.ProductRepository;


@Service
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }
    public ProductService()
    {

    }
    public boolean saveProduct(ProductModel productModel)
    {
        try{

         productRepository.save(productModel);
            return true;
            
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public ProductModel getProduct(int id)
    {
        return productRepository.findById(id).orElse(null);
    }
    public Optional<ProductModel> getbyId(Integer productId)
    {
        return productRepository.findById(productId);
    }
    public List<ProductModel>getAllProduct()
    {
        return productRepository.findAll();
    }
    public boolean updateProduct(int id ,ProductModel productModel)
    {
        if(this.getProduct(id) == null)
        {
            return false;
        }
                try{
                    // productRepository.setId(id);
                productRepository.save(productModel);
            }
            catch(Exception e)
            {
                return false;
            }
    //    productRepository.save(productModel);
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getbyId(id) == null)
        {
            return false;
        }
                try{
                   
                productRepository.deleteById(id);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
    }
    public Page<ProductModel> producPage(int offset , int pageSize , String field)
    {
        return productRepository.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
    }
}

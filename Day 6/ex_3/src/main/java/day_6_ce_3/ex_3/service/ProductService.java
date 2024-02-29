package day_6_ce_3.ex_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import day_6_ce_3.ex_3.model.Product;
import day_6_ce_3.ex_3.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public boolean post(Product product)
    {
        try {
            productRepo.save(product);
        } catch (Exception e) {
            System.out.println("\nError");

            System.out.println(e.getMessage());
            System.out.println("\nError");
            return false;
        }
        return true;
    }
    public List<Product> getPage(int offset , int pageSize)
    {
        return productRepo.findAll(PageRequest.of(offset , pageSize)).getContent();
    }
    public List<Product> getSortedPage(int offset , int pageSize , String field)
    {
        return productRepo.findAll(PageRequest.of(offset , pageSize,Sort.by(field))).getContent();
    }
    public Product getById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}


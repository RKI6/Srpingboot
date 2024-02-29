package day_4_3.ex_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import day_4_3.ex_3.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
    @Query("SELECT a FROM Product a WHERE a.id = :id")
    
}

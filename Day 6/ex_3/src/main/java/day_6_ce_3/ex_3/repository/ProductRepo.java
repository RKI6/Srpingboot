package day_6_ce_3.ex_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import day_6_ce_3.ex_3.model.Product;

public interface ProductRepo extends JpaRepository<Product , Integer>{
    
}

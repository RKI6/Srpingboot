package com.ce_2.ex_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ce_2.ex_2.model.Recipe;

public interface RecipeRepo extends JpaRepository<Recipe , Integer>{
    @Query("select r from Recipe r where recipeName=?1")
    List<Recipe> findByProduct(String name);
}

package com.ce_2.ex_2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ce_2.ex_2.model.Recipe;
import com.ce_2.ex_2.repository.RecipeRepo;

@Service
public class RecipeService {
     @Autowired
    private RecipeRepo recipeRepo;

  
    @SuppressWarnings("null")
    public boolean post(Recipe recipe)
    {
        try
        {
            recipeRepo.save(recipe);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public Recipe getByid(int id)
    {
        return recipeRepo.findById(id).orElse(null);
    }

    public List<Recipe> filter(String name)
    {
        return recipeRepo.findByProduct(name);
    }
}

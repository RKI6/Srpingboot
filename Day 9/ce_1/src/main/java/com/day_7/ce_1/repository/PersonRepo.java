package com.day_7.ce_1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.day_7.ce_1.model.Person;

public interface PersonRepo extends JpaRepository<Person , Integer>{
      @Query("SELECT p FROM Person p WHERE age=?1")
   List<Person> findByAge(int age);    
}

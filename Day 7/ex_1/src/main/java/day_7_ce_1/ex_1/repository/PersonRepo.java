package day_7_ce_1.ex_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import day_7_ce_1.ex_1.model.Person;

import java.util.Collections;
import java.util.List;


public interface PersonRepo extends JpaRepository<Person , Integer>{
    List<Person> findByAge(int age); 
    @Query("SELECT p FROM Person p WHERE p.age = ?1")
    Collections<Person> findAll()
}

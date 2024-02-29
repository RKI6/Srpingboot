package day_6_ce_2.ex_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import day_6_ce_2.ex_2.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
    
}

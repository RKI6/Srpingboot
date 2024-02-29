package day_6_ce.ex_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import day_6_ce.ex_1.model.Children;

public interface ChildrenRepo extends JpaRepository<Children , Integer>{
    
}

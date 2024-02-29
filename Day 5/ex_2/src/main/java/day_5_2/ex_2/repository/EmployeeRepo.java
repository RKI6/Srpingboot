package day_5_2.ex_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import day_5_2.ex_2.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
    
}

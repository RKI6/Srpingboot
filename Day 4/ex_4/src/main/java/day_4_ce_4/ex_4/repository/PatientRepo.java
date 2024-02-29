package day_4_ce_4.ex_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import day_4_ce_4.ex_4.model.Patient;

public interface PatientRepo extends JpaRepository<Patient , Integer>{
    
}

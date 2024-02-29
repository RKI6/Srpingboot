package com.medicine_1.medicine_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicine_1.medicine_1.model.Medicine;
@Repository
public interface MedicineRepo extends JpaRepository<Medicine, Integer>{
    
}

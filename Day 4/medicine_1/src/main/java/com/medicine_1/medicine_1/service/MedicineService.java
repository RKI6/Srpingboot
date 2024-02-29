package com.medicine_1.medicine_1.service;

import java.util.List;
import java.util.Optional;

// import org.hibernaing.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine_1.medicine_1.model.Medicine;
import com.medicine_1.medicine_1.repository.MedicineRepo;

@Service
public class MedicineService {
    private MedicineRepo medicineRepo;
    @Autowired
    public MedicineService(MedicineRepo medicineRepo)
    {
        this.medicineRepo = medicineRepo;
    }
    public MedicineService()
    {

    }
    // public String saveMedicine(Medicine medicine)
    // {
    //     medicineRepo.save(medicine);
    //     medicineList.add(medicine);
    //     return "Saved";
    // }
    public List<Medicine> getAllMedicine()
    {
        return medicineRepo.findAll();
    }
    public boolean savedMedicine(Medicine medicine)
    {
        try{
            medicineRepo.save(medicine);
        }
        catch(Exception e)
        {
            System.out.println("\nExceptioin");
            System.out.println(e.getMessage());
            System.out.println("\nExceptioin");
            return false;
        }
        NullPointerException p;
        return true;
    }
    public Optional<Medicine> getMedicine(Integer medicineId)
    {
            Optional<Medicine> medicine = medicineRepo.findById(medicineId);
            return medicine;
    }
}

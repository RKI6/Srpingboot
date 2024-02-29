package day_4_ce_4.ex_4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import day_4_ce_4.ex_4.model.Patient;
import day_4_ce_4.ex_4.repository.PatientRepo;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;
    
    public boolean post(Patient patient)
    {
        try {
            patientRepo.save(patient);
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
        return true;
    }
    public List<Patient>getAll()
    {
        return patientRepo.findAll();
    }
    public Patient getById(int id)
    {
        return patientRepo.findById(id).orElse(null);
    }
}

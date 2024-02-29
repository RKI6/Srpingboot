package day_4_ce_4.ex_4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import day_4_ce_4.ex_4.model.Patient;
import day_4_ce_4.ex_4.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("/api/patient")
    public ResponseEntity <List<Patient>> getAll() {
        List list = patientService.getAll();
        return new ResponseEntity<>(list , HttpStatus.OK);
        
    }
    @GetMapping("/api/patient/{patientId}")
    public ResponseEntity<Patient> getMethod(@PathVariable int patientId) {
        // return new String();
        Patient patient = patientService.getById(patientId);
        if(patient != null)
        return new ResponseEntity<>(patient , HttpStatus.OK);
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
    @PostMapping("/api/patient")
    public ResponseEntity<Patient> postMethodName(@RequestBody Patient patient) {
        //TODO: process POST request
        if(patientService.post(patient) == true)
        return new ResponseEntity<>(patient , HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        
        // return entity;
    }
    
    
    
}

package com.medicine_1.medicine_1.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.medicine_1.medicine_1.model.Medicine;
import com.medicine_1.medicine_1.service.MedicineService;

import org.apache.el.stream.Optional;
// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MedicineController {
    private MedicineService medicineService;
    @Autowired
public MedicineController(MedicineService medicineService)
{
    this.medicineService = medicineService;
}
public MedicineController()
{

}
    @GetMapping("/api/medicines")
    public List<Medicine> getAllDetail() {
        return medicineService.getAllMedicine();
    }
    
    @PostMapping("/api/medicine")
    public ResponseEntity postMedicine(@RequestBody Medicine medicine ) {
        if(medicineService.savedMedicine(medicine) == true)
        {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @SuppressWarnings("null")
    @GetMapping("/api/medicine.{medicineId}")
    public ResponseEntity getDetailBy(@PathVariable Integer medicineId) {
        if( medicineService.getMedicine(medicineId) == null)
        return new ResponseEntity<>( null,HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>( medicineService.getMedicine(medicineId) , HttpStatus.CREATED);
    }
    
    
}

package day_5_2.ex_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import day_5_2.ex_2.model.Employee;
import day_5_2.ex_2.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/api/employee")
    public ResponseEntity<Employee> postMethod(Employee employee) {
        if(employeeService.postEmployee(employee) == true)
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        

    }
    @PutMapping("/api/employee/{employeeId}")
    public ResponseEntity<Employee> putMethod(@PathVariable int employeeId, Employee employee) {

        if(employeeService.putEmployee(employeeId , employee) == true)
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/api/employee/{employeeId}")
    public ResponseEntity<Employee> deleteMethod(@PathVariable int employeeId) {

        if(employeeService.deleteEmployee(employeeId) == true)
        return new ResponseEntity<>(null,HttpStatus.CREATED);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
}

package day_7_ce_1.ex_1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import day_7_ce_1.ex_1.model.Person;
import day_7_ce_1.ex_1.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PersonController {
    @Autowired
    private  PersonService personService;
    @GetMapping("api/person/byAge/{age}")
    public ResponseEntity<List<Person>> getMethodName(@PathVariable int age) {
        List list = personService.getByAge(age);
        return new ResponseEntity<>(list , HttpStatus.OK);
    }
    @PostMapping("api/person")
    public ResponseEntity<Person> postMethodName(@RequestBody Person person) {
        //TODO: process POST request
        if(personService.post(person) == true)
        return new ResponseEntity<>( person,HttpStatus.CREATED);
        return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        // return entity;
    }

    @GetMapping("api/person")
    public ResponseEntity<List<Person>> getMethodName() {
        List list = personService.getAll();
        return new ResponseEntity<>(list , HttpStatus.OK);
    }
    
    
    
}

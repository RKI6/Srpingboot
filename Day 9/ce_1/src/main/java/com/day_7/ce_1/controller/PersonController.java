package com.day_7.ce_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.day_7.ce_1.model.Person;
import com.day_7.ce_1.service.PersonService;

@RestController
public class PersonController {
    @Autowired
    public PersonService personService;

   @PostMapping({"/api/person"})
   public ResponseEntity<Person> postMethodName(@RequestBody Person person) {
      return this.personService.savePerson(person) ? new ResponseEntity(person, HttpStatus.CREATED) : new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
   }

   @GetMapping({"/api/person/byage/{age}"})
   public ResponseEntity<List<Person>> getMethodName(@PathVariable("age") int age) {
      List<Person> list = this.personService.getPersonByAge(age);
      return list.size() == 0 ? new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR) : new ResponseEntity(list, HttpStatus.OK);
   }
}

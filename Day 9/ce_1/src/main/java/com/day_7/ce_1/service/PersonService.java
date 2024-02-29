package com.day_7.ce_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day_7.ce_1.model.Person;
import com.day_7.ce_1.repository.PersonRepo;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
     public boolean savePerson(Person person) {
      try {
         this.personRepo.save(person);
         return true;
      } catch (Exception var3) {
         return false;
      }
   }

   public List<Person> getPersonByAge(int age) {
      return this.personRepo.findByAge(age);
   }
}

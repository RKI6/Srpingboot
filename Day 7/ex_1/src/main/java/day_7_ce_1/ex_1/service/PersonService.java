package day_7_ce_1.ex_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day_7_ce_1.ex_1.model.Person;
import day_7_ce_1.ex_1.repository.PersonRepo;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
    public List<Person> getByAge(int age)
    {
        return personRepo.findByAge(age);
    }
    public boolean post(Person person)
    {
        try {
            personRepo.save(person);
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
        return true;
    }
    public List<Person> getAll()
    {
        return personRepo.findAll();
    }
}

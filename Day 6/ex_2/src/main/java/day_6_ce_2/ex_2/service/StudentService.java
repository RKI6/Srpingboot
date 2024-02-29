package day_6_ce_2.ex_2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import day_6_ce_2.ex_2.model.Student;
import day_6_ce_2.ex_2.repository.StudentRepo;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
     public boolean post(Student student)
    {
        try {
            studentRepo.save(student);
        } catch (Exception e) {
            System.out.println("\nError");
            System.out.println(e.getMessage());
            System.out.println("\nError");
            
            return false;
        }
        return true;
    }
    public List<Student> getPage(int offset , int pageSize)
    {
        return studentRepo.findAll(PageRequest.of(offset, pageSize)).getContent();
    }
    public Page<Student> getSortedPage(int offset , int pageSize , String field)
    {
        return studentRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
    }
}

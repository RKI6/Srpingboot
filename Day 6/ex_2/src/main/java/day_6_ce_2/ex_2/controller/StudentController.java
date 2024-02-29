package day_6_ce_2.ex_2.controller;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import day_6_ce_2.ex_2.model.Student;
import day_6_ce_2.ex_2.service.StudentService;
@RequestMapping("/api/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping()
    public ResponseEntity<Student> postMethodName(@RequestBody Student student) {
        if(studentService.post(student) == true)
        return new ResponseEntity<>(student , HttpStatus.CREATED);
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @GetMapping("sortBy/{field}")
    // public List <Student> getMethodName(@PathVariable String field) {
    //         return studentService.getSort(field);
    // }
    @GetMapping("sortBy/{offset}/{pageSize}")
    public List<Student> getMethodName(@PathVariable int offset , @PathVariable int pageSize) {
            return studentService.getPage(offset, pageSize);

    }
    @GetMapping("sortBy/{offset}/{pageSize}/{field}")
    public Page<Student> getMethodName(@PathVariable String field , @PathVariable int offset , @PathVariable int pageSize) {
            return studentService.getSortedPage(offset, pageSize, field);

    }
}

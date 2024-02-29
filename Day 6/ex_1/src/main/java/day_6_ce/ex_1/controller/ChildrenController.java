package day_6_ce.ex_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import day_6_ce.ex_1.model.Children;
import day_6_ce.ex_1.service.ChildrenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/children")
public class ChildrenController {
    @Autowired
    private ChildrenService childrenService;
    @PostMapping()
    public ResponseEntity<Children> postMethodName(@RequestBody Children children) {
        if(childrenService.postChildren(children) == true)
        return new ResponseEntity<>(children , HttpStatus.CREATED);
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    // @GetMapping("sortBy/{field}")
    // public List<Children> getMethodName(@PathVariable String field) {
    //         return childrenService.getSort(field);
    // }
    @GetMapping("sortBy/{offset}/{pageSize}")
    public List<Children> getMethodName(@PathVariable int offset , @PathVariable int pageSize) {
            return childrenService.getPage(offset, pageSize);

    }
    @GetMapping("sortBy/{offset}/{pageSize}/{field}")
    public Page<Children> getMethodName(@PathVariable String field , @PathVariable int offset , @PathVariable int pageSize) {
            return childrenService.getSortedPage(offset, pageSize, field);

    }
    
    
}
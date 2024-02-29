package com.d2_ex_4.d2_4.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.d2_ex_4.d2_4.model.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BookController {
    @GetMapping("/path")
    public Book getMethodName(@RequestParam String param) {
        // return new String();
        Book b = new Book("The Great Soldier", "G Gyan", );
    }
    
}

package com.day12.day1_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/{Name}")
    public String getMethodName(@PathVariable("Name") String studentName)
    {
        return "Welcome " + studentName;
    }
}

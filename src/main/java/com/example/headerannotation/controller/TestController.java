package com.example.headerannotation.controller;

import com.example.headerannotation.annotation.EmployeeHeader;
import com.example.headerannotation.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/employee/get")
    public Employee employee(@EmployeeHeader  Employee employee,String message){
        employee.setEmployeeName(message);
        return employee;
    }
}

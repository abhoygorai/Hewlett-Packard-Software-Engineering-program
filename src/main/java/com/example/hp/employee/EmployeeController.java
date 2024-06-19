package com.example.hp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeManager manager;

    @GetMapping
    public Employees getAllEmployees(){
        return manager.getAllEmployees();
    }

    @PostMapping
    public void addEmployees(@RequestBody Employee e){
        manager.addEmployee(e);
    }
}

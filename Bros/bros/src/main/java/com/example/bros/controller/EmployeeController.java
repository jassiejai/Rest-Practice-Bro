package com.example.bros.controller;


import com.example.bros.model.Employee;
import com.example.bros.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    Get/Read Method
    @GetMapping(path = "/bros")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
//    Post/Create Method
    @PostMapping(path = "/bro")
    public Employee createEmployee(@RequestBody Employee employeeObject){
        return employeeService.createEmployee(employeeObject);
    }

//    Put/Update Method
    @PutMapping(path = "/bro/{broId}")
    public Employee updateEmployee(@PathVariable(value = "broId") Long employeeId, @RequestBody Employee employeeObject ){

        return employeeService.updateEmployee(employeeId, employeeObject);
    }
//    Delete/Delete Method
    @DeleteMapping(path = "/bro/{broId}")
    public String deleteEmployee(@PathVariable(value = "broId") Long employeeId){
        return "Deleting the employee with id of " + employeeId;
    }

}

package com.example.bros.service;


import com.example.bros.model.Employee;
import com.example.bros.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    Get method
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

//    post/create method
    public Employee createEmployee(Employee employeeObject){

        return employeeRepository.save(employeeObject);
    }

//    update method
    public Employee updateEmployee(Long employeeId, Employee employeeObject){
        Employee employee = employeeRepository.getById(employeeId);

        employee.setName(employeeObject.getName());
        return employeeRepository.save(employee);

    }
//    delete method
    public Employee deleteEmployee(Long employeeId){

        Employee employee = employeeRepository.getById(employeeId);

        employeeRepository.delete(employee);
        return employee;
    }



}

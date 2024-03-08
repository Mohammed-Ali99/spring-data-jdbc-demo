package com.spring.hr.controller;

import com.spring.hr.entity.Employee;
import com.spring.hr.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    Logger log = LoggerFactory.getLogger(EmployeeController.class);


    @GetMapping("/count")
    public long count() {
        return employeeService.count();
    }

    @GetMapping("")
    public Iterable<Employee> findAll() {
        log.info("hey all employees are returned");
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/filter")
    public List<Employee> findByName(@RequestParam String name ,@RequestParam String salary) {
        return employeeService.findByNameAndSalary(name , salary);
    }

    @PostMapping("")
    public Employee add(@RequestBody Employee emp) {
        return employeeService.add(emp);
    }

    @PutMapping("")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @PutMapping("/salary")
    public int updateSalary(@RequestParam String salary ,@RequestParam Long id) {
        return employeeService.updateSalary(salary , id);
    }

}

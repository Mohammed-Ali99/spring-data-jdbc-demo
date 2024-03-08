package com.spring.hr.service;

import com.spring.hr.entity.Employee;
import com.spring.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public long count() {
        return employeeRepository.count();
    }

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findByNameAndSalary(String name , String salary) {
        return employeeRepository.findByNameAndSalary(name , salary);
    }

    public Employee add(Employee emp) {
        return employeeRepository.save(emp);
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public int updateSalary(String salary , Long id) {
        return employeeRepository.updateSalary(salary , id);
    }



}

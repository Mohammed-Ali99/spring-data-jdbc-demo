package com.spring.hr.repository;

import com.spring.hr.entity.Employee;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee , Long> {

    List<Employee> findByNameAndSalary(String name , String salary);

    @Query("select count(*) from employee")
    long count();

    @Modifying
    @Query("update employee set salary = :salary where id = :id")
    int updateSalary(String salary , Long id);

}

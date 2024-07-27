package com.spring.demo.dao;

import com.spring.demo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();
    Employee findbyId(int id);
    Employee save(Employee employee);
    void delete(int id);
}

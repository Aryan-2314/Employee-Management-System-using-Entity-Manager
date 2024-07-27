package com.spring.demo.controller;

import com.spring.demo.entity.Employee;
import com.spring.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Getting list of employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = employeeService.findAll();
        if(employeeList == null)
        {
            throw new RuntimeException("Employee not found");
        }
        return employeeList;
    }

    //Getting a single employee
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        Employee employee = employeeService.findbyId(id);
        if(employee == null)
        {
            throw new RuntimeException("Employee not found at this id : "+id);
        }
        return employee;
    }

    //Update a employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        Employee employee1 = employeeService.save(employee);
        return employee1;
    }



    //Adding a employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        //Here just in case if the client add the id
        employee.setId(0);
        //Execute the methods and getting the result
        Employee employee1 = employeeService.save(employee);
        //Checking the result
        if(employee1 == null)
        {
            throw new RuntimeException("Employee didn't add");
        }
        return employee1;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        //Check if the user is exits or not
        Employee employee = employeeService.findbyId(id);
        if(employee == null)
        {
            throw new RuntimeException("Employee not found");
        }
        employeeService.delete(id);
        return "Deleted employee id is "+id;
    }
}

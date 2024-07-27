package com.spring.demo.dao;

import com.spring.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        //get the list
        List<Employee> list = theQuery.getResultList();
        //return the list
        return list;
    }

    @Override
    public Employee findbyId(int id) {
        //get a employee
        Employee employee = entityManager.find(Employee.class,id);
        //return a employee
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        //get a employee
        Employee emp = entityManager.merge(employee);
        //return a employee
        return emp;
    }

    @Override
    public void delete(int id) {
        //get a employee
        Employee employee = entityManager.find(Employee.class,id);
        //remove the employee
        entityManager.remove(employee);
    }
}

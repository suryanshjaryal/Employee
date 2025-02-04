package com.example.Employee.service;

import com.example.Employee.Exception.EmployeeAlreadyExistsException;
import com.example.Employee.Model.Employee;
import com.example.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
   @Autowired
   private EmployeeRepository employeeRepository;

    public boolean saveEmployee(Employee employee) {
        if (employeeRepository.existsByName(String.valueOf(employee.getName()))) {
            throw new EmployeeAlreadyExistsException("Employee with name " + employee.getName() + " " + "Already Exists " + "Status Code = " + HttpStatus.CONFLICT);

        } else {
            employeeRepository.save(employee);
            return true;
        }
    }
    public List<Employee> saveAllEmployees(List<Employee> employees) {
        List<Employee> savedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (!employeeRepository.existsByName(employee.getName())) {
                savedEmployees.add(employeeRepository.save(employee));
            } else {
                throw new EmployeeAlreadyExistsException("Employee with name " + employee.getName() + " already exists. Skipping this entry.");
            }
        }
        return savedEmployees;
    }

    public Employee getEmployeeByName(String name) {
        return (Employee) employeeRepository.findByName(name).orElseThrow(() -> new RuntimeException("Employee with name " + name + " not found."));
    }

    public Employee findByName(String name) {
        return null;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())){
            return employeeRepository.save(employee);
        }
        return null;
    }
    public List<Employee> updateAllEmployees(List<Employee> employees) {
        List<Employee> updatedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employeeRepository.existsById(employee.getId())) {
                updatedEmployees.add(employeeRepository.save(employee));
            }
        }
        return updatedEmployees;
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }}

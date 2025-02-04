package com.example.Employee.Repository;

import com.example.Employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {



    boolean existsByName(String employee);


    Optional<Employee> findByName(String name);

}

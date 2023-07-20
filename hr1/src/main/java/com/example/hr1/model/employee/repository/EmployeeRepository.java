package com.example.hr1.model.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hr1.model.employee.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    
    Optional<EmployeeEntity> findByEmployeeId(Integer emplyeeId);

    List<EmployeeEntity> findByFirstNameContainingIgnoreCase(String firstName);
    
}

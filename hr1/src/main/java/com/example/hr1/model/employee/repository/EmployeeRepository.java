package com.example.hr1.model.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr1.model.employee.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    
    Optional<EmployeeEntity> findByEmployeeId(Integer emplyeeId);
}

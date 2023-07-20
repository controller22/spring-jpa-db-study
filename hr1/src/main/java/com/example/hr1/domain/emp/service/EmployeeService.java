package com.example.hr1.domain.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr1.domain.emp.dto.EmpDetailDTO;
import com.example.hr1.domain.emp.dto.EmpTableDTO;
import com.example.hr1.model.employee.entity.EmployeeEntity;
import com.example.hr1.model.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmpTableDTO> getSearchEmpTTbleData(String firstName){
        // firstName이 null이면 findAll
        // 아닌 경우 findByFirstName ~
        if (firstName==null) {
            
            return EmpTableDTO.fromEntityList(employeeRepository.findAll());
        } else {
            return EmpTableDTO.fromEntityList(employeeRepository.findByFirstNameContainingIgnoreCase(firstName));
        }
    }

    public List<EmpTableDTO> getempListPageData() {
       
        return EmpTableDTO.fromEntityList(employeeRepository.findAll());
    }

    public EmpDetailDTO getEmpDetailData(Integer employeeId) {
        Optional<EmployeeEntity> employeesEntityOPtional = employeeRepository.findById(employeeId);

        if (!employeesEntityOPtional.isPresent()) {
            throw new RuntimeException("잘못된 요청입니다.");
        }

        return EmpDetailDTO.fromEntity(employeesEntityOPtional.get());
    }

}

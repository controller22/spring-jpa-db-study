package com.example.hr1.domain.emp.dto;

import java.util.List;

import com.example.hr1.model.employee.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpTableDTO {
    private Integer employeeId;
    private String firstName;

    public static EmpTableDTO fromEntity(EmployeeEntity employeeEntity) {
        return builder()
                .employeeId(employeeEntity.getEmployeeId())
                .firstName(employeeEntity.getFirstName())
                .build();
    }

    public static List<EmpTableDTO> fromEntityList(List<EmployeeEntity> employeesEntityList) {
        return employeesEntityList
                .stream()
                .map((employeesEntity) -> fromEntity(employeesEntity))
                .toList();
    }
    
}

package com.example.hr1.domain.emp.dto;

import com.example.hr1.model.employee.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpDetailDTO {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Integer salary;

    public static EmpDetailDTO fromEntity(EmployeeEntity employeeEntity){

        return builder()
        .employeeId(employeeEntity.getEmployeeId())
        .firstName(employeeEntity.getFirstName())
        .lastName(employeeEntity.getLastName())
        .salary(employeeEntity.getSalary())
        .build();
    }
}

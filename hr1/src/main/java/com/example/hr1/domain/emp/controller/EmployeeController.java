package com.example.hr1.domain.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.hr1.domain.emp.dto.EmpDetailDTO;
import com.example.hr1.domain.emp.dto.EmpTableDTO;
import com.example.hr1.domain.emp.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp")
    // Mapping을 기반으로 함수 실행 -> controller의 함수 이름은 중요 X
    public ModelAndView empListPage(@RequestParam(required = false) String firstName) {

        // firstName이 null이면 전체리스트 / 값이 있으면 조건 검색 리스트

        System.out.println("디버그 : " + firstName);

        ModelAndView modelAndView = new ModelAndView();
        List<EmpTableDTO> empTableDTO = employeeService.getSearchEmpTTbleData(firstName);
        modelAndView.addObject("empTableDTO", empTableDTO);
        modelAndView.setViewName("emp/emp-list");

        return modelAndView;
    }

    @GetMapping("/emp/{employeeId}")
    public ModelAndView empDetailPage(@PathVariable Integer employeeId) {

        System.out.println("디버그 : " + employeeId);

        ModelAndView modelAndView = new ModelAndView();
        EmpDetailDTO EmpDetailDTOList = employeeService.getEmpDetailData(employeeId);
        modelAndView.addObject("EmpDetailDTOList", EmpDetailDTOList);
        modelAndView.setViewName("emp/emp-detail");

        return modelAndView;
    }
}

package com.example.hr1.domain.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.hr1.domain.main.dto.ResMainDTO;
import com.example.hr1.domain.main.dto.ResUpdateDTO;
import com.example.hr1.domain.main.service.MainService;

@Controller
public class MainController {
    @Autowired
    private MainService mainService;
    
    @GetMapping("/")
    // Mapping을 기반으로 함수 실행 -> controller의 함수 이름은 중요 X
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<ResMainDTO> resMainDTOList = mainService.getMainPageData();
        modelAndView.addObject("resMainDTOList", resMainDTOList);
        modelAndView.setViewName("main/main");
        return modelAndView;
    }
    
    @GetMapping("/update/{regionId}")
    // Mapping을 기반으로 함수 실행 -> controller의 함수 이름은 중요 X
    public ModelAndView updatePage(@PathVariable Integer regionId) {
        ModelAndView modelAndView = new ModelAndView();
        ResUpdateDTO resUpdateDTO = mainService.getUpdatePageData(regionId);
        modelAndView.addObject("resUpdateDTO", resUpdateDTO);
        modelAndView.setViewName("main/update");
        return modelAndView;
    }

}

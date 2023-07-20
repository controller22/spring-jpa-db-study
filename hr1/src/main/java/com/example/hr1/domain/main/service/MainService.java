package com.example.hr1.domain.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr1.domain.main.dto.ReqInsertMainDTO;
import com.example.hr1.domain.main.dto.ResMainDTO;
import com.example.hr1.model.regions.entity.RegionsEntity;
import com.example.hr1.model.regions.repository.RegionsRepository;

import jakarta.transaction.Transactional;

// 약속
// entity 객체는 Service를 빠져나가지 못함
// entity -> dto

@Service
public class MainService {

    // IoC 컨테이너에서 RegionsRepository타입의 객체를 가져옴
    // 의존성 주입 DI
    @Autowired
    private RegionsRepository regionsRepository;

    public void postMainData(ReqInsertMainDTO reqInsertMainDTO){
        
        long count = regionsRepository.count();


        RegionsEntity regionsEntity = RegionsEntity.builder()
            .regionId((int)count+1)
            .regionName(reqInsertMainDTO.getRegionsName())
            .build();

        regionsRepository.save(regionsEntity);

    }

    @Transactional
    public List<ResMainDTO> getMainPageData() {

        List<RegionsEntity> regionsEntityList = regionsRepository.findAll();

        List<ResMainDTO> resMainDTOList = regionsEntityList
                .stream()
                .map((regionsEntity) -> ResMainDTO.fromEntity(regionsEntity))
                .toList();

        return resMainDTOList;
    }

   
}

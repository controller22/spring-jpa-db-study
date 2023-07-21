package com.example.hr1.domain.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hr1.domain.main.dto.ReqInsertMainDTO;
import com.example.hr1.domain.main.dto.ReqUpdateDTO;
import com.example.hr1.domain.main.dto.ResMainDTO;
import com.example.hr1.domain.main.dto.ResUpdateDTO;
import com.example.hr1.model.regions.entity.RegionsEntity;
import com.example.hr1.model.regions.repository.RegionsRepository;

// 약속
// entity 객체는 Service를 빠져나가지 못함
// entity -> dto

@Service
@Transactional(readOnly = true)
public class MainService {

    // IoC 컨테이너에서 RegionsRepository타입의 객체를 가져옴
    // 의존성 주입 DI
    @Autowired
    private RegionsRepository regionsRepository;

    @Transactional
    public void postMainData(ReqInsertMainDTO reqInsertMainDTO) {

        // long count = regionsRepository.count();

        RegionsEntity regionsEntity = RegionsEntity.builder()
                // .regionId((int) count + 1)
                .regionName(reqInsertMainDTO.getRegionsName())
                .build();

        regionsRepository.save(regionsEntity);
    }

    public List<ResMainDTO> getMainPageData() {

        List<RegionsEntity> regionsEntityList = regionsRepository.findAll();

        List<ResMainDTO> resMainDTOList = regionsEntityList
                .stream()
                .map((regionsEntity) -> ResMainDTO.fromEntity(regionsEntity))
                .toList();

        return resMainDTOList;
    }

    @Transactional
    public ResUpdateDTO getUpdatePageData(Integer regionId) {

        RegionsEntity regionsEntity = regionsRepository.findByRegionId(regionId);

        return ResUpdateDTO.fromEntity(regionsEntity);
    }

    @Transactional
    public void deleteMainData(Integer regionId) {
        RegionsEntity regionsEntity = regionsRepository.findByRegionId(regionId);
        if (regionsEntity == null) {
            throw new RuntimeException("이미 삭제된 지역입니다.");
        }
        regionsRepository.delete(regionsEntity);
    }

    @Transactional
    // 매개 변수 수정
    public void updatemainData(Integer regionId, ReqUpdateDTO reqUpdateDTO) {
        // regionId 받아서 넣기
        RegionsEntity regionsEntity = regionsRepository.findByRegionId(regionId);

        if (regionsEntity == null) {
            throw new RuntimeException("잘못된 요첟입니다.");
        }
        // spring data jpa는 더티체킹을 사용
        // 데이터베이스 가져온 데이터(엔티티) 변경 시 자동으로 update 쿼리를 날림

        // dto에서 변경된 이름 받아서 넣기

        regionsEntity.setResionName(reqUpdateDTO.getRegionsName());

    }
}

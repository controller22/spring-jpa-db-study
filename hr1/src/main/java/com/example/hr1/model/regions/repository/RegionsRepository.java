package com.example.hr1.model.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr1.model.regions.entity.RegionsEntity;
import java.util.List;


@Repository
public interface RegionsRepository  extends JpaRepository<RegionsEntity, Integer> {
    // 특정 엔티티 단일 데이터 가져오기
    // SELECT * from regions where region_id =?
    RegionsEntity findByRegionId(Integer regionId);

    // region_name으로 데이터 가져오기
    //  region_name은 유니크하지 않기 때문에 여러개를 가져올 수 있음
    // RegionsEntity findByRegionName(String regionName);
    // List 타입으로 가져와야 함
    List<RegionsEntity> findByRegionName(String regionName);

    // region_id과 region_name이 둘 다 조건이 맞는 경우 == 단일값
    // find - select * from regions
    // by - where
    // and - and
    RegionsEntity findByRegionIdAndRegionName(Integer regionId,String regionName);

}

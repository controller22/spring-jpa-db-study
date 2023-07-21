package com.example.hr1.domain.main.dto;

import com.example.hr1.model.regions.entity.RegionsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResUpdateDTO {

    private Integer regionsId;
    private String regionsName;

    public static ResUpdateDTO fromEntity(RegionsEntity regionsEntity){
        return new ResUpdateDTO(regionsEntity.getRegionId(), regionsEntity.getRegionName());
    }

}
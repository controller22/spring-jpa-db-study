package com.example.hr1.domain.main.dto;

import com.example.hr1.model.regions.entity.RegionsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResMainDTO {
    
    private Integer regionsId;
    private String regionsName;

    public static ResMainDTO fromEntity(RegionsEntity regionsEntity){
        return new ResMainDTO(regionsEntity.getRegionId(), regionsEntity.getRegionName());
    }

}

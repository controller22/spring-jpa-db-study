package com.example.hr1.model.regions.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// DB 테이블 명 + Entity

// 엔티티임을 명시
@Entity
// 데이터베이스의 테이블과 연동
@Table(name="regions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
// entity에서 setter는 꼭 필요한 경우만 사용
// toString도 직접 만드는 것을 추천
public class RegionsEntity {
    // 기본키 (PK)에 @Id를 붙인다.
    @Id
    // 데이터베이스에 있는 컬럼명 연결
    // 컬럼의 속성을 맞춰주는 것이 좋음
    @Column(name="region_id",nullable = false ,unique = true)
    private Integer regionId;

    @Column(name="region_name")
    private String regionName;

    @Override
    public String toString() {
        return "RegionsEntity [regionId=" + regionId + ", regionName=" + regionName + "]";
    }

}

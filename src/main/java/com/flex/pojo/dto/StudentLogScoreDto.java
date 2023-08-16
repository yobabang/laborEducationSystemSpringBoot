package com.flex.pojo.dto;

import lombok.Data;

@Data
public class StudentLogScoreDto {
    private String userName;
    private String className;
    private long userId;
    private Integer dailyScore;
    private Integer serviceScore;
    private Integer productionScore;
    private Integer totalWeightedScore;
}

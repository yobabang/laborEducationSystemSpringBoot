package com.flex.pojo.dto;

import lombok.Data;

@Data
public class LogScoreDto {
    private int logType;
    private long userId;
    private String logScore;
    private int logState;

}

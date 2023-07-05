package com.flex.pojo.dto;

import lombok.Data;

@Data
public class LogDto {
    private Integer logType;
    private String logContent;
    private String location;
    private String logProcess;
    private String effect;
    private String result;
    private String logTime;
    private String logState;
}

package com.flex.pojo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class LogDto {
    private int logType;
    private long userId;
    private int userType;
    private String logName;
    private String logUnit;
    private String logClasses;
    private String logContent;
    private String location;
    private String logProcess;
    private String effect;
    private String result;
    private Date logTime;
    private int logState;
    private Date logMark;
}

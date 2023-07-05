package com.flex.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Log {
    private Long logId;
    private Integer logType;
    private String userNumber;
    private Integer userType;
    private String logName;
    private String logUnit;
    private String logClasses;
    private String logContent;
    private String location;
    private String logProcess;
    private String effect;
    private String result;
    private Date logTime;
    private String logScore;
    private Integer logState;
    private Integer logMark;

}

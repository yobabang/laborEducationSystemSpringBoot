package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("log")
public class Log {
    private long logId;
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
    private String logScore;
    private int logState;
    private Date logMark;
}

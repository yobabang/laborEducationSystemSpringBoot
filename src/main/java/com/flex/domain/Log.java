package com.flex.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@TableName("log")
public class Log {
    @TableId(type = IdType.AUTO,value = "log_id")
    private Long logId;
    private Integer logType;
    private Long userId;
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
    private Date logMark;
}

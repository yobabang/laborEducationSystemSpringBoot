package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("register")
public class Register {
    private long regId;
    private Integer regNature;
    private Integer userType;
    private String regName;
    private String regClass;
    private String regUnit;
    private long userId;
    private long adId;
    private String politics;
    private Date startTime;
    private Date endTime;
    private Integer form;
    private long praId;
    private Date regLogTime;
    private String regLog;
    private int regState;
    private Date registerMark;
    private long reportId;
}

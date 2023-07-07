package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("register")
public class Register {
    private Long regId;
    private Integer regNature;
    private Integer userType;
    private String regName;
    private String regClass;
    private String regUnit;
    private Long userId;
    private Long adId;
    private String politics;
    private Date startTime;
    private Date endTime;
    private Integer form;
    private Long praId;
    private Date regLogTime;
    private String regLog;
    private Integer regState;
    private Date registerMark;
    private Long reportId;
}

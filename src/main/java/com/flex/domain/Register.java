package com.flex.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Register {
    private Long registerId;
    private Integer userType;
    private String registerName;
    private String registerClasses;
    private String registerUnit;
    private String registerNumber;
    private String politics;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer form;
    private Integer praId;
    private LocalDateTime registerLogTime;
    private String registerLog;
    private Integer registerState;
    private Integer registerMark;
    private Integer reportId;

}

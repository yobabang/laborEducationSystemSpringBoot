package com.flex.domain;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class RegisterReport {
    private Integer reportId;
    private String report;
    private LocalDateTime reportTime;
    private Integer reportState;
    private String reportScore;
    private Integer reportMark;
}

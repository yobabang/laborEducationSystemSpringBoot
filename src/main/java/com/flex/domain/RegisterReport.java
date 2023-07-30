package com.flex.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("register_report")
public class RegisterReport {
    private Long repId;
    private Long userId;
    private Integer repNature;
    private String repBackground;
    private String repPlace;
    private Date repTime;
    private String repObject;
    private String repContent;
    private String repProcess;
    private String repIssue;
    private String repGain;
    private Integer repState;
    private String repScore;
    private Date reportMark;
}

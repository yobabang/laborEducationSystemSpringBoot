package com.flex.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("register_report")
public class RegisterReport {
    private long repId;
    private Integer repNature;
    private String repContent;
    private Date repTime;
    private int repState;
    private String repScore;
    private Date reportMark;
}

package com.flex.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("register_report")
public class RegisterReport {
    private Long repId;
    private Long userId;
    private Integer repNature;
    private String repContent;
    private Date repTime;
    private Integer repState;
    private String repScore;
    private Date reportMark;
}

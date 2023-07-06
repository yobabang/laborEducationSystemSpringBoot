package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("assessment")
public class Assessment {
    private long assId;
    private String assName;
    private long userId;
    private long classId;
    private String assMajor;
    private String assUnit;
    private long adId;
    private String assDep;
    private String assLog;
    private String assReport;
    private Integer assGrade;
    private String assOpi;

}

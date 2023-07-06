package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("assessment")
public class Assessment {
    private Long assId;
    private String assName;
    private Long userId;
    private Long classId;
    private String assMajor;
    private String assUnit;
    private Long adId;
    private String assDep;
    private String assLog;
    private String assReport;
    private Integer assGrade;
    private String assOpi;

}

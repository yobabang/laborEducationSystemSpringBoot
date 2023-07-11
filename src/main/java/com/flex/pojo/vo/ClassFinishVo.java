package com.flex.pojo.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ClassFinishVo {
    private Integer total;
    private Integer finish;
    private Integer submit;
    private Date lastTime;
}

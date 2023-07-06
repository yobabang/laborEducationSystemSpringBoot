package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("practice")
public class Practice {
    private Integer praId;
    private String praUnit;
    private String project;
    private String registerLocation;
    private String unitAttribute;
    private String head;
    private String headPhone;
    private String headEmail;
    private String item;
    private String registerStatus;
    private String unitMajor;
    private String objIntro;
}

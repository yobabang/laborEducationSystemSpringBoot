package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ad_user")
public class AdUser {
    private String adName;
    private String adAccount;
    private String adPassword;
    private int obj;
    private Integer adAlter;
    private long adId;
    private String adPhone;
    private String adEmail;
    private String remark;
}

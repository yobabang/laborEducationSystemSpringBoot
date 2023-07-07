package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ad_user")
public class AdUser {
    private String adName;
    private String adAccount;
    private String adPassword;
    private Integer obj;
    private Integer adAlter;
    private Long adId;
    private String adPhone;
    private String adEmail;
    private String remark;
}

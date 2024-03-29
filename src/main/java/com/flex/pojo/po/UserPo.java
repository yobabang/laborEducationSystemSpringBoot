package com.flex.pojo.po;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPo {
    private Long userId;
    private String userName;
    private Integer userAlter;
    private String unit;
    private String grade;
    private String major;
    private String className;
    private String politics;
    private String phone;
    private String email;
    private Integer type;
    private Long adId;
}

package com.flex.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private long userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private Integer userAlter;
    private String unit;
    private String grade;
    private String major;
    private long classId;
    private String politics;
    private String phone;
    private String email;
    private String remark;
    private int type;
    private long adId;
    private int number;
}

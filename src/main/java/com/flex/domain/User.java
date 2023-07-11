package com.flex.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private Long userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private Integer userAlter;
    private String unit;
    private String grade;
    private String major;
    private Long classId;
    private String politics;
    private String phone;
    private String email;
    private String remark;
    private Integer type;
    private Long adId;
}

package com.flex.domain;


import lombok.Data;

@Data
public class User {
    private Long userId;
    private String userName;
    private String userAccount;
    private String userPassword;
    private Integer alterSign;
    private String unit;
    private String grade;
    private String major;
    private String classes;
    private String politics;
    private String phone;
    private String email;
    private String remark;
    private Integer type;
    private Integer userAdName;
}

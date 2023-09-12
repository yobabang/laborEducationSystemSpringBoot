package com.flex.pojo.dto;

import lombok.Data;

@Data
public class UserImportDto {
    private Long userId;
    private String userName;
    private String unit;
    private String grade;
    private String major;
    private Integer classId;
    private String politics;
    private String phone;
    private String email;
    private Integer type;
}

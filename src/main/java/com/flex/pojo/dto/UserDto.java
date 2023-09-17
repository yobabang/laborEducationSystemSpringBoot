package com.flex.pojo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long userId;
    private String userName;
    private String unit;
    private String grade;
    private String major;
    private String className;
    private String politics;
    private String phone;
    private String email;
    private String typeName;
    private String adName;
}

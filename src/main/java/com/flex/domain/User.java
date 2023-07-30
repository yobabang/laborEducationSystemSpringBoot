package com.flex.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import com.flex.pojo.po.UserPo;
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

    public static UserPo toUserPO(User user){

        return UserPo.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userAlter(user.getUserAlter())
                .unit(user.getUnit())
                .grade(user.getGrade())
                .major(user.getMajor())
                .politics(user.getPolitics())
                .phone(user.getPhone())
                .email(user.getEmail())
                .type(user.getType())
                .adId(user.getAdId())
                .build();
    }

}

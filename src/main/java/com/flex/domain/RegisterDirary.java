package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("register_diary")
public class RegisterDirary {
    private long rdId;
    private long regId;
    private long userId;
    private Date rdTime;
    private String rdContent;
    private int rdState;
}

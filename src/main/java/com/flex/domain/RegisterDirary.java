package com.flex.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("register_diary")
public class RegisterDirary {
    @TableId(type = IdType.AUTO,value = "rd_id")
    private Long rdId;
    private Long regId;
    private Long userId;
    private Date rdTime;
    private String rdContent;
    private int rdState;
}

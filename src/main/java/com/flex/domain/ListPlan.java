package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("list_plan")
public class ListPlan {
    private Long listId;
    private Long adId;
    private Integer listType;
    private String listName;
    private Date listTime;
    private String listUnit;
    private String listGrade;
    private String listMajor;
    private String listClass;
    private String userId;
    private Long noticeId;
}

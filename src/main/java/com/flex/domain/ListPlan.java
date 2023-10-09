package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@TableName("list_plan")
public class ListPlan {
    private Long listId;
    private Integer listType;
    private LocalDateTime listTime;
    private String listUnit;
    private String listGrade;
    private String listMajor;
    private String listClass;
    private Long userId;
    private Long noticeId;
    private Integer listState;
}

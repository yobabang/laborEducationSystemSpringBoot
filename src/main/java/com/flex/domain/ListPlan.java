package com.flex.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ListPlan {
    private Long listId;
    private Integer listObj;
    private String listName;
    private LocalDateTime listTime;
    private String listUnit;
    private String listGrade;
    private String listMajor;
    private String listClasses;
    private String listNumber;
    private Integer listNoticeId;


}

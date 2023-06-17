package com.flex.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Blog {
    private Long blogId;
    private String blogTitle;
    private String blogContent;
    private String auName;
    private LocalDateTime releaseTime;
    private String label;
    private Integer blogRead;
    private Integer likes;
    private Integer comments;
    private String fileAdd;
    private Integer blogState;
    private LocalDateTime saveTime;


}

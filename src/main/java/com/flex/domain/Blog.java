package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("blog")
public class Blog {
    private Long blogId;
    private String blogTitle;
    private String blogContent;
    private String auName;
    private Date releaseTime;
    private String label;
    private Integer blogRead;
    private Integer likes;
    private Long comments;
    private String fileAdd;
    private Integer blogState;
    private Date saveTime;
}

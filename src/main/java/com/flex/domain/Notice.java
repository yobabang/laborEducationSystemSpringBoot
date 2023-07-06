package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notice")
public class Notice {
    private long noticeId;
    private String noticeTitle;
    private String noticeContent;
    private long adId;
    private int noticeType;
    private String noticeReceiver;
    private Long userId;
}

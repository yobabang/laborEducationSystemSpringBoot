package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notice")
public class Notice {
    private Long noticeId;
    private String noticeTitle;
    private String noticeContent;
    private Long adId;
    private Integer noticeType;
    private String noticeReceiver;
    private Long userId;
}

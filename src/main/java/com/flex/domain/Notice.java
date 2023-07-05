package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("notice")
public class Notice {
    private Integer noticeId;
    private String noticeTitle;
    private String noticeContent;
    private Integer noticeObj;
    private Integer noticeType;
    private String noticeReceiver;
}

package com.flex.domain;

import lombok.Data;

@Data
public class Notice {
    private Integer noticeId;
    private String noticeTitle;
    private String noticeContent;
    private Integer noticeObj;
    private Integer noticeType;
    private Integer noticeReceiver;
}

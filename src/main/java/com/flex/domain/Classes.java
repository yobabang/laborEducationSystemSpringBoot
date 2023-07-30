package com.flex.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@TableName("classes")
public class Classes {
    private Long classId;
    private String className;
    private String remark;
}

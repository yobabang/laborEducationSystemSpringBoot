package com.flex.pojo.vo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ClassFinishVo {
    private Integer totalCount;
    private Integer state1Count;
    private Integer state3Count;
    @TableId("")
    private Date lastTime;
}

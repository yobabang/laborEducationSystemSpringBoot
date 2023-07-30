package com.flex.pojo.dto;

import com.flex.domain.RegisterReport;
import com.flex.pojo.po.UserPo;
import lombok.Data;

@Data
public class ReReportUserDto {
    private UserPo userPo;
    private RegisterReport registerReport;
}

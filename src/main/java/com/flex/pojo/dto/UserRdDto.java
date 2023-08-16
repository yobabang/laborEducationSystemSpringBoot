package com.flex.pojo.dto;

import com.flex.domain.RegisterDirary;
import com.flex.pojo.po.UserPo;
import lombok.Data;

@Data
public class UserRdDto {
    private UserPo userPo;
    private RegisterDirary registerDirary;
}

package com.flex.pojo.dto;

import com.flex.domain.Practice;
import com.flex.domain.Register;
import lombok.Data;


@Data
public class PraRegDto {
    private Register register;
    private Practice practice;
}

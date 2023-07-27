package com.flex.domain;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterDirary {
    private long rdId;
    private long regId;
    private long userId;
    private Date rdTime;
    private String rdContent;
    private int rdState;
}

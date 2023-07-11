package com.flex.controller;


import com.flex.dao.AdUserDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aduser")
@Api(tags = "管理员接口")
public class AdUserController {
    @Autowired
    private AdUserDao adUserDao;


}

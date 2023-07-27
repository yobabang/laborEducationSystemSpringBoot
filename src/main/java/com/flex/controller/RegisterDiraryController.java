package com.flex.controller;

import com.flex.dao.RegisterDiraryDao;
import com.flex.domain.Register;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regs")
@Api(tags = "社会实践活动登记管理")
public class RegisterDiraryController {
    @Autowired
    private RegisterDiraryDao registerDiraryDao;


}

package com.flex.controller;

import com.flex.dao.RegisterDiraryDao;
import com.flex.domain.RegisterDirary;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regs")
@Api(tags = "社会实践活动登记管理")
public class RegisterDiraryController {
    @Autowired
    private RegisterDiraryDao registerDiraryDao;

    @PostMapping("/add")
    public Result addregisterDirary(@RequestBody RegisterDirary registerDirary){
        Integer code;
        String msg;
        int insert = registerDiraryDao.insert(registerDirary);
        if (insert == 1 ){
            code = Code.SAVE_OK;
            msg = "添加成功";
        }else{
            code = Code.SAVE_ERR;
            msg = "添加失败";
        }
        return new Result(code,msg);
    }

}

package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flex.dao.RegisterDiraryDao;
import com.flex.domain.RegisterDirary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regdir")
@Api(tags = "社会实践活动日志管理")
public class RegisterDiraryController {
    @Autowired
    private RegisterDiraryDao registerDiraryDao;


    @ApiOperation(value = "添加社会活动日志", notes = "添加社会活动日志")
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

    @ApiOperation(value = "查询社会实践活动日志", notes = "根据社会时间活动日志ID查询社会实践活动日志")
    @ApiImplicitParam(name = "rdId", value = "社会时间活动日志ID", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/rdId/{rdId}")
    public Result getRdByRdId(@PathVariable Long rdId){
        RegisterDirary registerDirary = registerDiraryDao.selectById(rdId);
        Integer code = registerDirary != null ? Code.GET_OK : Code.GET_ERR;
        String msg = registerDirary != null ? "" : "数据查询失败";
        return new Result(code,registerDirary,msg);
    }

    @ApiOperation(value = "查询社会实践活动日志", notes = "根据用户ID查询社会实践活动日志")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/userId/{userId}")
    public Result getRdByUserId(@PathVariable Long userId){
        LambdaQueryWrapper<RegisterDirary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RegisterDirary::getUserId,userId);
        List<RegisterDirary> registerDiraries = registerDiraryDao.selectList(queryWrapper);
        Integer code = registerDiraries != null ? Code.GET_OK : Code.GET_ERR;
        String msg = registerDiraries != null ? "" : "数据查询失败";
        return new Result(code,registerDiraries,msg);
    }


}

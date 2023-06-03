package com.flex.controller;

import com.flex.domain.Log;
import com.flex.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@Api(tags = "日常生活劳动日志管理")
public class LogController {
    @Autowired
    private LogService logService;

    @ApiOperation(value = "添加日常生活劳动日志", notes = "添加日常生活劳动日志信息")
    @PostMapping
    public Result save(@RequestBody Log log){
        boolean flag = logService.save(log);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @ApiOperation(value = "更新日常生活劳动日志", notes = "更新日常生活劳动日志信息")
    @PutMapping
    public Result updata(@RequestBody Log log){
        boolean flag = logService.update(log);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @ApiOperation(value = "删除日常生活劳动日志", notes = "根据日常生活劳动日志ID删除日常生活劳动日志信息")
    @ApiImplicitParam(name = "logId", value = "日常生活劳动日志ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = logService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @ApiOperation(value = "查询日常生活劳动日志", notes = "根据日常生活劳动日志ID查询日常生活劳动日志信息")
    @ApiImplicitParam(name = "logId", value = "日常生活劳动日志ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Log log = logService.getById(id);
        Integer code = log != null ? Code.GET_OK : Code.GET_ERR;
        String msg = log != null ? "" : "数据查询失败";
        return  new Result(code,log,msg);
    }

    @ApiOperation(value = "获取所有日常生活劳动日志信息", notes = "获取所有日常生活劳动日志信息")
    @GetMapping
    public Result getAll(){
        List<Log> logs = logService.getAll();
        Integer code = logs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = logs != null ? "" : "数据查询失败";
        return new Result(code,logs,msg);
    }
}

package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.flex.dao.ListPlanDao;
import com.flex.dao.LogDao;
import com.flex.domain.ListPlan;
import com.flex.domain.Log;
import com.flex.pojo.dto.LogDto;
import com.flex.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@Api(tags = "劳动日志管理")
public class LogController {
    @Autowired
    private LogService logService;

    @Autowired
    private LogDao logDao;

    @Autowired
    private ListPlanDao listPlanDao;


    @ApiOperation(value = "删除劳动日志", notes = "根据劳动日志ID删除劳动日志信息")
    @ApiImplicitParam(name = "logId", value = "劳动日志ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = logService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @ApiOperation(value = "查询劳动日志", notes = "根据劳动日志ID查询劳动日志信息")
    @ApiImplicitParam(name = "logId", value = "劳动日志ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Log log = logService.getById(id);
        Integer code = log != null ? Code.GET_OK : Code.GET_ERR;
        String msg = log != null ? "" : "数据查询失败";
        return  new Result(code,log,msg);
    }

    @ApiOperation(value = "获取所有劳动日志信息", notes = "获取所有劳动日志信息")
    @GetMapping
    public Result getAll(){
        List<Log> logs = logService.getAll();
        Integer code = logs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = logs != null ? "" : "数据查询失败";
        return new Result(code,logs,msg);
    }

    @ApiOperation(value = "查询学生劳动日志", notes = "根据学生学号和日志类型查询劳动日志信息")
    @ApiImplicitParam(name = "userId,logType", value = "学生学和日志类型", required = true, dataType = "String",paramType = "path")
    @GetMapping("/userId/{userId}/{logType}")
    public Result getLogByUserid(@PathVariable Long userId,@PathVariable String logType){
        try {
            LambdaQueryWrapper<Log> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Log::getUserId, userId)
                    .eq(Log::getLogType,logType);
            List<Log> logs = logDao.selectList(queryWrapper);

            Integer code = logs != null ? Code.GET_OK : Code.GET_ERR;
            String msg = logs != null ? "" : "数据查询失败";
            return new Result(code, logs, msg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(5001, null, "数据查询报错");
        }
    }

    @ApiOperation(value = "添加劳动日志", notes = "添加劳动日志信息")
    @PostMapping("/insert")
    public Result insert(@RequestBody Log log){
        Integer code;
        String msg;

        int insert = logDao.insert(log);
        if (insert == 1 ){
            code = Code.SAVE_OK;
            msg = "添加成功";
        }else{
            code = Code.SAVE_ERR;
            msg = "添加失败";
        }
        //同步首页任务状态
        LambdaUpdateWrapper<ListPlan> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ListPlan::getUserId,log.getUserId())
                .eq(ListPlan::getListType,log.getLogType())
                .set(ListPlan::getListState,log.getLogState());
        listPlanDao.update(null,updateWrapper);
        return new Result(code,msg);
    }

    @ApiOperation(value = "修改劳动日志", notes = "修改劳动日志信息")
    @PostMapping("/update")
    public Result update(@RequestBody Log log){
        LambdaQueryWrapper<Log> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(Log::getUserId,log.getUserId())
                        .eq(Log::getLogType,log.getLogType());
        logDao.delete(queryWrapper1);

        Integer code;
        String msg;

        int insert = logDao.insert(log);
        if (insert == 1 ){
            code = Code.SAVE_OK;
            msg = "添加成功";
        }else{
            code = Code.SAVE_ERR;
            msg = "添加失败";
        }
        //同步首页任务状态
        LambdaQueryWrapper<ListPlan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ListPlan::getUserId,log.getUserId())
                .eq(ListPlan::getListType,log.getLogType());
        LambdaUpdateWrapper<ListPlan> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(ListPlan::getListState,log.getLogState());
        listPlanDao.update(null,updateWrapper);
        return new Result(code,msg);
    }

    @ApiOperation(value = "查询学生劳动日志", notes = "根据劳动日志Id查询劳动日志信息")
    @ApiImplicitParam(name = "logId", value = "劳动日志id", required = true, dataType = "String",paramType = "path")
    @GetMapping("/logId/{logId}")
    public Result getLogByLogId(@PathVariable Long logId){
        try {
            LambdaQueryWrapper<Log> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Log::getLogId, logId);
            List<Log> logs = logDao.selectList(queryWrapper);

            Integer code = logs != null ? Code.GET_OK : Code.GET_ERR;
            String msg = logs != null ? "" : "数据查询失败";
            return new Result(code, logs, msg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(5001, null, "数据查询报错");
        }
    }
}

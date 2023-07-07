package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.flex.dao.ListPlanDao;
import com.flex.dao.RegisterReportDao;
import com.flex.domain.ListPlan;
import com.flex.domain.Log;
import com.flex.domain.RegisterReport;
import com.flex.service.RegisterReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registerReports")
@Api(tags = "社会实践活动报告管理")
public class RegisterReporController {

    @Autowired
    private RegisterReportService registerReportService;
    @Autowired
    private RegisterReportDao registerReportDao;

    @Autowired
    private ListPlanDao listPlanDao;

    @ApiOperation(value = "添加社会实践活动报告", notes = "添加社会实践活动报告信息")
    @PostMapping
    public Result save(@RequestBody RegisterReport registerReport){
        boolean flag = registerReportService.save(registerReport);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }


    @ApiOperation(value = "更新社会实践活动报告", notes = "更新社会实践活动报告信息")
    @PutMapping
    public Result updata(@RequestBody RegisterReport registerReport){
        boolean flag = registerReportService.update(registerReport);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @ApiOperation(value = "删除社会实践活动报告", notes = "根据社会实践活动报告ID删除社会实践活动报告户信息")
    @ApiImplicitParam(name = "reportId", value = "社会实践活动报告ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = registerReportService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @ApiOperation(value = "查询社会实践活动报告", notes = "根据社会实践活动报告ID查询社会实践活动报告户信息")
    @ApiImplicitParam(name = "reportId", value = "社会实践活动报告ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        RegisterReport registerReport = registerReportService.getById(id);
        Integer code = registerReport != null ? Code.GET_OK : Code.GET_ERR;
        String msg = registerReport != null ? "" : "数据查询失败";
        return  new Result(code,registerReport,msg);
    }

    @ApiOperation(value = "获取所有社会实践活动报告信息", notes = "获取所有社会实践活动报告信息")
    @GetMapping
    public Result getAll(){
        List<RegisterReport> registerReports = registerReportService.getAll();
        Integer code = registerReports != null ? Code.GET_OK : Code.GET_ERR;
        String msg = registerReports != null ? "" : "数据查询失败";
        return new Result(code,registerReports,msg);
    }

    @ApiOperation(value = "查询社会实践活动报告信息", notes = "根据学生学号查询社会实践活动报告信息")
    @ApiImplicitParam(name = "userId", value = "学生学号", required = true, dataType = "String",paramType = "path")
    @GetMapping("/userId/{userId}")
    public Result getRegisterReport(@PathVariable Long userId){
            try{
                LambdaQueryWrapper<RegisterReport> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(RegisterReport::getUserId,userId);
                List<RegisterReport> registerReports = registerReportDao.selectList(queryWrapper);
                Integer code = registerReports != null ? Code.GET_OK : Code.GET_ERR;
                String msg = registerReports != null ? "查询成功" : "数据查询失败";
                return new Result(code, registerReports, msg);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(5001, null, "数据查询报错");
            }
    }

    @ApiOperation(value = "添加社会实践活动报告信息", notes = "添加社会实践活动报告信息")
    @PostMapping("/insert")
    public Result insert(@RequestBody RegisterReport registerReport){
        Integer code;
        String msg;
        int insert = registerReportDao.insert(registerReport);
        if (insert == 1 ){
            code = Code.SAVE_OK;
            msg = "添加成功";
        }else{
            code = Code.SAVE_ERR;
            msg = "添加失败";
        }

        //设置list_pan状态
        LambdaQueryWrapper<ListPlan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ListPlan::getUserId,registerReport.getUserId());
        LambdaUpdateWrapper<ListPlan> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(ListPlan::getListState,registerReport.getRepState());
        listPlanDao.update(null,updateWrapper);

        return new Result(code,msg);
    }
}

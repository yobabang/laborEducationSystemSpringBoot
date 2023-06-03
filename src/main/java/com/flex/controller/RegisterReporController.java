package com.flex.controller;

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
}

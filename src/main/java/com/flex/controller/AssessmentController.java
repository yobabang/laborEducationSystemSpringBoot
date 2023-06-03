package com.flex.controller;

import com.flex.domain.Assessment;
import com.flex.service.AssessmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessments")
@Api(tags = "成绩判定管理")
public class AssessmentController {
    @Autowired
    private AssessmentService assessmentService;

    @ApiOperation(value = "添加成绩判定", notes = "添加成绩判定信息")
    @PostMapping
    public Result save(@RequestBody Assessment assessment){
        boolean flag = assessmentService.save(assessment);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @ApiOperation(value = "更新成绩判定", notes = "更新成绩判定信息")
    @PutMapping
    public Result updata(@RequestBody Assessment assessment){
        boolean flag = assessmentService.update(assessment);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @ApiOperation(value = "删除成绩判定", notes = "根据成绩判定ID删除成绩判定信息")
    @ApiImplicitParam(name = "assessmentId", value = "成绩判定ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = assessmentService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @ApiOperation(value = "查询成绩判定", notes = "根据成绩判定ID查询成绩判定信息")
    @ApiImplicitParam(name = "assessmentId", value = "成绩判定ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Assessment assessment = assessmentService.getById(id);
        Integer code = assessment != null ? Code.GET_OK : Code.GET_ERR;
        String msg = assessment != null ? "" : "数据查询失败";
        return  new Result(code,assessment,msg);
    }

    @ApiOperation(value = "获取所有成绩判定信息", notes = "获取所有成绩判定信息")
    @GetMapping
    public Result getAll(){
        List<Assessment> assessments = assessmentService.getAll();
        Integer code = assessments != null ? Code.GET_OK : Code.GET_ERR;
        String msg = assessments != null ? "" : "数据查询失败";
        return new Result(code,assessments,msg);
    }
}

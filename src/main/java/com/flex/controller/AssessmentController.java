package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flex.dao.AssessmentDao;
import com.flex.dao.ClassesDao;
import com.flex.domain.Assessment;
import com.flex.domain.Classes;
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

    @Autowired
    private ClassesDao classesDao;

    @Autowired
    private AssessmentDao assessmentDao;

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

    @ApiOperation(value = "获得导出成绩文件名", notes = "按班级导出，获得导出成绩文件名")
    @GetMapping("/className/{className}")
    public Result downAssessment(@PathVariable String className){
        LambdaQueryWrapper<Classes> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Classes::getClassName,className);
        Classes classes = classesDao.selectOne(queryWrapper);

        LambdaQueryWrapper<Assessment> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(Assessment::getClassId,classes.getClassId());
        List<Assessment> assessments = assessmentDao.selectList(queryWrapper1);
        String assessmentFileName = assessmentService.createAssessmentFile(assessments, classes.getClassName());
        Integer code = assessmentFileName != null ? Code.GET_OK : Code.GET_ERR;
        String msg = assessmentFileName != null ? "" : "生成失败";
        return new Result(code,assessmentFileName,msg);
    }
}

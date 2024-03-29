package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.flex.dao.ListPlanDao;
import com.flex.dao.RegisterReportDao;
import com.flex.domain.ListPlan;
import com.flex.domain.Log;
import com.flex.domain.Register;
import com.flex.domain.RegisterReport;
import com.flex.pojo.dto.ReReportUserDto;
import com.flex.pojo.dto.RegisterReportScoreDto;
import com.flex.pojo.po.UserPo;
import com.flex.service.RegisterReportService;
import com.flex.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/registerReports")
@Api(tags = "社会实践活动报告管理")
public class RegisterReportController {

    @Autowired
    private RegisterReportService registerReportService;
    @Autowired
    private RegisterReportDao registerReportDao;

    @Autowired
    private UserService userService;

    @Autowired
    private ListPlanDao listPlanDao;


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

        LambdaQueryWrapper<RegisterReport> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RegisterReport::getUserId,registerReport.getUserId());
        RegisterReport register1 = registerReportDao.selectOne(queryWrapper);

        if(register1 != null){
            Map<String, Object> condition = new HashMap<>();
            condition.put("rep_id",register1.getRepId());
            registerReportDao.deleteByMap(condition);
            registerReport.setRepId(register1.getRepId());
        }

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
        LambdaUpdateWrapper<ListPlan> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ListPlan::getUserId,registerReport.getUserId())
                .eq(ListPlan::getListType,6)
                .set(ListPlan::getListState,registerReport.getRepState());
        listPlanDao.update(null,updateWrapper);

        return new Result(code,msg);
    }

    @ApiOperation(value = "查询社会实践活动报告信息", notes = "根据学生班级查询社会实践活动报告信息")
    @ApiImplicitParam(name = "className", value = "学生班级", required = true, dataType = "String",paramType = "path")
    @GetMapping("/classses/{className}")
    public Result getRegisterReportByClasses(@PathVariable String className){
        List<RegisterReport> registerReports = registerReportService.getByClasses(className);
        List<ReReportUserDto> reReportUserDtos = new ArrayList<>();

        for (RegisterReport re: registerReports
             ) {
            UserPo userPo = userService.selectByUserID(re.getUserId());
            userPo.setClassName(className);

            ReReportUserDto reReportUserDto = new ReReportUserDto();
            reReportUserDto.setRegisterReport(re);
            reReportUserDto.setUserPo(userPo);

            reReportUserDtos.add(reReportUserDto);
        }


        Integer code = reReportUserDtos != null ? Code.GET_OK : Code.GET_ERR;
        String msg = reReportUserDtos != null ? "" : "数据查询失败";
        return new Result(code,reReportUserDtos,msg);
    }



    @ApiOperation(value = "批量操作学生社会实践活动报告", notes = "批量操作学生社会实践活动报告")
    @PutMapping("/score")
    public Result updateReportScores(@RequestBody List<RegisterReport> registerReports){
        for (RegisterReport rep: registerReports
             ) {
            LambdaUpdateWrapper<RegisterReport> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.eq(RegisterReport::getUserId,rep.getUserId());
            registerReportDao.update(rep,updateWrapper);
        }
        Integer code = Code.UPDATE_OK;
        String msg = "更新成功";
        return new Result(code, msg);
    }

    @ApiOperation(value = "上传学生社会实践活动报告成绩", notes = "根据学生Id上传社会实践活动报告成绩")
    @PutMapping("/approval")
    public Result updateRepByUserId(@RequestBody RegisterReportScoreDto registerReportScoreDto){
        LambdaUpdateWrapper<RegisterReport> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(RegisterReport::getUserId,registerReportScoreDto.getUserId())
                .set(RegisterReport::getRepState,registerReportScoreDto.getRepState())
                .set(RegisterReport::getRepScore,registerReportScoreDto.getRepScore());
        int update = registerReportDao.update(null, updateWrapper);
        Integer code;
        String msg;
        if (update == 1 ){
            code = Code.SAVE_OK;
            msg = "添加成功";
        }else{
            code = Code.SAVE_ERR;
            msg = "添加失败";
        }
        return new Result(code,msg);
    }
}

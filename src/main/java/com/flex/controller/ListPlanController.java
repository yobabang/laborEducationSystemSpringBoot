package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flex.dao.ListPlanDao;
import com.flex.domain.ListPlan;
import com.flex.pojo.vo.ClassFinishVo;
import com.flex.service.ListPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listPlans")
@Api(tags = "计划清单管理")
public class ListPlanController {
    @Autowired
    private ListPlanService listPlanService;

    @Autowired
    private ListPlanDao listPlanDao;


    @ApiOperation(value = "删除计划清单", notes = "根据计划清单ID删除计划清单信息")
    @ApiImplicitParam(name = "listPlanId", value = "计划清单ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = listPlanService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }


    @ApiOperation(value = "获取所有计划清单信息", notes = "获取所有计划清单信息")
    @GetMapping
    public Result getAll(){
        List<ListPlan> listPlans = listPlanService.getAll();
        Integer code = listPlans != null ? Code.GET_OK : Code.GET_ERR;
        String msg = listPlans != null ? "" : "数据查询失败";
        return new Result(code,listPlans,msg);
    }

    @ApiOperation(value = "获取计划清单信息", notes = "根据学院年纪专业获取计划清单信息")
    @GetMapping("/{unit}/{grade}/{major}")
    public Result getByUnitGradeMajor(@PathVariable String unit,@PathVariable String grade,@PathVariable String major){
        try{
            LambdaQueryWrapper<ListPlan> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ListPlan::getListUnit,unit)
                    .eq(ListPlan::getListGrade,grade)
                    .eq(ListPlan::getListMajor,major);
            List<ListPlan> listPlans = listPlanDao.selectList(queryWrapper);
            Integer code = listPlans != null ? Code.GET_OK : Code.GET_ERR;
            String msg = listPlans != null ? "数据查询成功" : "数据查询失败";
            return new Result(code, listPlans, msg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(5001, null, "数据查询报错");
        }
    }

    @ApiOperation(value = "获取计划清单信息", notes = "根据用户id获取计划清单信息")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/{userId}")
    public Result getByUserId(@PathVariable Long userId){
        LambdaQueryWrapper<ListPlan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ListPlan::getUserId,userId);
        List<ListPlan> listPlans = listPlanDao.selectList(queryWrapper);
        System.out.println(listPlans);
        Integer code = listPlans != null ? Code.GET_OK : Code.GET_ERR;
        String msg = listPlans != null ? "数据查询成功" : "数据查询失败";
        return new Result(code, listPlans, msg);
    }

    @ApiOperation(value = "获取计划清单完成信息", notes = "根据班级和计划类型获取计划清单完成信息")
    @ApiImplicitParam(name = "listClass,listType", value = "班级和计划类型", required = true, dataType = "String，Integer",paramType = "path")
    @GetMapping("/{listClass}/{listType}")
    public Result getPlanByClassType(@PathVariable String listClass,@PathVariable Integer listType){
        try {
            ClassFinishVo planByClassType = listPlanDao.getPlanByClassType(listClass, listType);
            System.out.println(planByClassType);
            return new Result(Code.GET_OK, planByClassType, "查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(Code.GET_OK, null, "查询成功");
        }
    }
}

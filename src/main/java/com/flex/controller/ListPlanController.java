package com.flex.controller;

import com.flex.domain.ListPlan;
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

    @ApiOperation(value = "添加计划清单", notes = "添加计划清单信息")
    @PostMapping
    public Result save(@RequestBody ListPlan listPlan){
        boolean flag = listPlanService.save(listPlan);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @ApiOperation(value = "更新计划清单", notes = "更新计划清单信息")
    @PutMapping
    public Result updata(@RequestBody ListPlan listPlan){
        boolean flag = listPlanService.update(listPlan);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @ApiOperation(value = "删除计划清单", notes = "根据计划清单ID删除计划清单信息")
    @ApiImplicitParam(name = "listPlanId", value = "计划清单ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = listPlanService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @ApiOperation(value = "查询计划清单", notes = "根据计划清单ID查询计划清单信息")
    @ApiImplicitParam(name = "listPlanId", value = "计划清单ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        ListPlan listPlan = listPlanService.getById(id);
        Integer code = listPlan != null ? Code.GET_OK : Code.GET_ERR;
        String msg = listPlan != null ? "" : "数据查询失败";
        return  new Result(code,listPlan,msg);
    }

    @ApiOperation(value = "获取所有计划清单信息", notes = "获取所有计划清单信息")
    @GetMapping
    public Result getAll(){
        List<ListPlan> listPlans = listPlanService.getAll();
        Integer code = listPlans != null ? Code.GET_OK : Code.GET_ERR;
        String msg = listPlans != null ? "" : "数据查询失败";
        return new Result(code,listPlans,msg);
    }
}

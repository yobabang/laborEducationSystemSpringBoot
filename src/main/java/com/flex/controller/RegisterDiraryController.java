package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.flex.dao.ListPlanDao;
import com.flex.dao.RegisterDiraryDao;
import com.flex.domain.ListPlan;
import com.flex.domain.RegisterDirary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/regdir")
@Api(tags = "社会实践活动日志管理")
public class RegisterDiraryController {
    @Autowired
    private RegisterDiraryDao registerDiraryDao;

    @Autowired
    private ListPlanDao listPlanDao;


    @ApiOperation(value = "添加社会活动日志", notes = "添加社会活动日志")
    @PostMapping("/add")
    public Result addregisterDirary(@RequestBody RegisterDirary registerDirary){
        LambdaQueryWrapper<RegisterDirary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RegisterDirary::getRdId,registerDirary.getRdId());

        RegisterDirary registerDirary1 = registerDiraryDao.selectOne(queryWrapper);

        if(registerDirary1 != null){
            Map<String,Object> condition = new HashMap<>();
            condition.put("rd_id",registerDirary1.getRdId());
            registerDiraryDao.deleteByMap(condition);
        }

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
        //同步首页任务状态
        LambdaUpdateWrapper<ListPlan> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ListPlan::getUserId,registerDirary.getUserId())
                .eq(ListPlan::getListType,5)
                .set(ListPlan::getListState,registerDirary.getRdState());
        listPlanDao.update(null,updateWrapper);
        return new Result(code,msg);
    }

    @ApiOperation(value = "查询社会实践活动日志", notes = "根据社实践活动日志ID查询社会实践活动日志")
    @ApiImplicitParam(name = "rdId", value = "社会时间活动日志ID", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/rdId/{rdId}")
    public Result getRdByRdId(@PathVariable Long rdId){
        LambdaQueryWrapper<RegisterDirary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RegisterDirary::getRdId,rdId);
        RegisterDirary registerDirary = registerDiraryDao.selectOne(queryWrapper);
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

    @ApiOperation(value = "删除社会实践活动日志", notes = "根据社实践活动日志ID删除社会实践活动日志")
    @DeleteMapping("/rdId")
    public void deleteByRdId(@RequestBody List<Long> rdIds){
        for (Long rdId: rdIds
             ) {
            LambdaQueryWrapper<RegisterDirary> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(RegisterDirary::getRdId,rdId);
            registerDiraryDao.delete(queryWrapper);
        }
    }

    @ApiOperation(value = "更新社会实践活动日志", notes = "根据社实践活动日志ID更新社会实践活动日志")
    @PatchMapping
    public Result updateByRdId(@RequestBody RegisterDirary registerDirary){
        Integer code;
        String msg;
        int insert = registerDiraryDao.updateById(registerDirary);
        if (insert == 1 ){
            code = Code.SAVE_OK;
            msg = "添加成功";
        }else{
            code = Code.SAVE_ERR;
            msg = "添加失败";
        }
        return new Result(code,msg);
    }
}

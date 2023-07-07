package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flex.dao.PracticeDao;
import com.flex.domain.Practice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practice")
@Api(tags = "社会实践单位表管理")
public class PracticeController {
    @Autowired
    private PracticeDao practiceDao;

    @ApiOperation(value = "查询社会实践单位表", notes = "根据学生学号查询社会实践单位表信息")
    @ApiImplicitParam(name = "userId", value = "学生学号", required = true, dataType = "String",paramType = "path")
    @GetMapping("/userId/{userId}")
    public Result getPracticeByUserid(@PathVariable Long userId){
        try{
            LambdaQueryWrapper<Practice> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Practice::getUserId,userId);
            List<Practice> practices = practiceDao.selectList(queryWrapper);

            Integer code = practices != null ? Code.GET_OK : Code.GET_ERR;
            String msg = practices != null ? "" : "数据查询失败";
            return new Result(code, practices, msg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(5001, null, "数据查询报错");
        }
    }

    @ApiOperation(value = "添加社会实践单位表", notes = "添加社会实践单位表")
    @PostMapping("/insert")
    public Result insert(@RequestBody Practice practice){
        Integer code;
        String msg;
        int insert = practiceDao.insert(practice);
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

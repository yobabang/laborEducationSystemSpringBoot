package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.flex.dao.ListPlanDao;
import com.flex.dao.PracticeDao;
import com.flex.dao.RegisterDao;
import com.flex.domain.ListPlan;
import com.flex.domain.Practice;
import com.flex.domain.Register;
import com.flex.pojo.dto.PraRegDto;
import com.flex.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/regs")
@Api(tags = "社会实践活动登记管理")
public class RegisterController {

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private ListPlanDao listPlanDao;

    @Autowired
    private PracticeDao practiceDao;




    @ApiOperation(value = "删除社会实践活动登记", notes = "根据社会实践活动登记ID删除社会实践活动登记信息")
    @ApiImplicitParam(name = "registerId", value = "社会实践活动登记ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = registerService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @ApiOperation(value = "查询社会实践活动登记", notes = "根据社会实践活动登记ID查询社会实践活动登记信息")
    @ApiImplicitParam(name = "registerId", value = "社会实践活动登记ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Register register = registerService.getById(id);
        Integer code = register != null ? Code.GET_OK : Code.GET_ERR;
        String msg = register != null ? "" : "数据查询失败";
        return  new Result(code,register,msg);
    }

    @ApiOperation(value = "获取所有社会实践活动登记信息", notes = "获取所有社会实践活动登记信息")
    @GetMapping
    public Result getAll(){
        List<Register> registers = registerService.getAll();
        Integer code = registers != null ? Code.GET_OK : Code.GET_ERR;
        String msg = registers != null ? "" : "数据查询失败";
        return new Result(code,registers,msg);
    }

    @ApiOperation(value = "查询学生社会活动登记表", notes = "根据学生学号查询社会活动登记表")
    @ApiImplicitParam(name = "userId", value = "学生学号", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/userId/{userId}")
    public Result getRegisterByUserId(@PathVariable Long userId){
        try {
            LambdaQueryWrapper<Register> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Register::getUserId, userId);
            List<Register> registers = registerDao.selectList(queryWrapper);

            Integer code = registers != null ? Code.GET_OK : Code.GET_ERR;
            String msg = registers != null ? "" : "数据查询失败";
            return new Result(code, registers, msg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(5001, null, "数据查询报错");
        }
    }

    @ApiOperation(value = "添加社会活动登记表", notes = "添加社会活动登记表")
    @PostMapping("/insert")
    public Result insert(@RequestBody PraRegDto praRegDto){
        Register register = praRegDto.getRegister();
        Practice practice = praRegDto.getPractice();

        LambdaQueryWrapper<Practice> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(Practice::getUserId,practice.getUserId());

        Practice practice1 = practiceDao.selectOne(queryWrapper1);

        if(practice1 != null){
            Map<String, Object> condition = new HashMap<>();
            condition.put("pra_id",practice1.getPraId());
            registerDao.deleteByMap(condition);
            practice.setPraId(practice1.getPraId());
        }

        practiceDao.insert(practice);

        LambdaQueryWrapper<Register> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Register::getUserId,register.getUserId());

        Register register1 = registerDao.selectOne(queryWrapper);

        if(register1 != null){
            Map<String, Object> condition = new HashMap<>();
            condition.put("reg_id",register1.getRegId());
            registerDao.deleteByMap(condition);
            register.setRegId(register1.getRegId());
        }

        Integer code;
        String msg;
        int insert = registerDao.insert(register);
        if (insert == 1 ){
            code = Code.SAVE_OK;
            msg = "添加成功";
        }else{
            code = Code.SAVE_ERR;
            msg = "添加失败";
        }
        //设置list_pan状态

        LambdaUpdateWrapper<ListPlan> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ListPlan::getUserId,register.getUserId())
                .eq(ListPlan::getListType,4)
                .set(ListPlan::getListState,register.getRegState());
        listPlanDao.update(null,updateWrapper);

        return new Result(code,msg);
    }


    @ApiOperation(value = "查询学生社会活动登记表", notes = "根据学生班级查询社会活动登记表")
    @ApiImplicitParam(name = "className", value = "学生班级", required = true, dataType = "String",paramType = "path")
    @GetMapping("/classses/{className}")
    public Result getRegisterByClasses(@PathVariable String  className){

        LambdaQueryWrapper<Register> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Register::getRegClass, className);
        List<Register> registers = registerDao.selectList(queryWrapper);

        Integer code = registers != null ? Code.GET_OK : Code.GET_ERR;
        String msg = registers != null ? "" : "数据查询失败";
        return new Result(code, registers, msg);

    }

}

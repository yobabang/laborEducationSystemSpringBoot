package com.flex.controller;

import com.flex.domain.Register;
import com.flex.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registers")
@Api(tags = "社会实践活动登记管理")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @ApiOperation(value = "添加社会实践活动登记", notes = "添加社会实践活动登记信息")
    @PostMapping
    public Result save(@RequestBody Register register){
        boolean flag = registerService.save(register);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @ApiOperation(value = "更新社会实践活动登记", notes = "更新社会实践活动登记信息")
    @PutMapping
    public Result updata(@RequestBody Register register){
        boolean flag = registerService.update(register);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

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
}

package com.flex.controller;

import com.flex.domain.User;
import com.flex.pojo.dto.LoginUserDto;
import com.flex.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "添加用户", notes = "添加用户信息")
    @PostMapping
    public Result save(@RequestBody User user){
        boolean flag = userService.save(user);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @PutMapping
    public Result update(@RequestBody User user){
        boolean flag = userService.update(user);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @ApiOperation(value = "删除用户", notes = "根据用户ID删除用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = userService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @ApiOperation(value = "获取用户信息", notes = "根据用户ID获取用户信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        User user = userService.getById(id);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "数据查询成功" : "数据查询失败";
        return  new Result(code,user,msg);
    }

    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息")
    @GetMapping
    public Result getAll(){
        List<User> userList = userService.getAll();
        Integer code = userList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = userList != null ? "数据查询成功" : "数据查询失败";
        return  new Result(code,userList,msg);
    }

}

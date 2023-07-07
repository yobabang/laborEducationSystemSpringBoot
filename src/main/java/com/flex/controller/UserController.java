package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.flex.dao.AdUserDao;
import com.flex.domain.AdUser;
import com.flex.domain.User;
import com.flex.pojo.dto.LoginUserDto;
import com.flex.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;
    @Autowired
    private AdUserDao adUserDao;


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

    @ApiOperation(value = "用户登陆", notes = "用户登陆")
    @ApiImplicitParam(name = "LoginUserDto", value = "用户Dto", required = true, dataType = "json",paramType = "post")
    @PostMapping("/{identity}")
    public Result login(@RequestBody LoginUserDto loginUserDto,@PathVariable Integer identity){
        HttpSession session = request.getSession();
        User user1 = null;
        AdUser user2 = null;
        if(identity == 1){
            user1 = userService.login(loginUserDto.getUserAccount(), loginUserDto.getUserPassword());
            session.setAttribute("user", user1);
        }else{
            QueryWrapper<AdUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("ad_account", loginUserDto.getUserAccount());
            queryWrapper.eq("ad_password", loginUserDto.getUserPassword());
            user2 = adUserDao.selectOne(queryWrapper);
            session.setAttribute("user", user2);
        }
        Integer code;
        String msg;
        if( user1 != null || user2 != null){
            code = Code.LOGIN_OK;
            msg = "登陆成功";
        }else {
            code = Code.LOGIN_ERR;
            msg = "登陆失败";
        }
        return new Result(code,msg);
    }

    @ApiOperation(value = "获取session", notes = "获取session")
    @GetMapping("/session")
    public Result getSession(){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return new Result(001,user,"session获取成功");
    }


}

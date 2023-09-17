package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.flex.dao.AdUserDao;
import com.flex.dao.ClassesDao;
import com.flex.dao.UserDao;
import com.flex.domain.AdUser;
import com.flex.domain.Classes;
import com.flex.domain.User;
import com.flex.pojo.dto.LoginUserDto;
import com.flex.pojo.dto.UserDto;
import com.flex.pojo.po.UserPo;
import com.flex.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private UserDao userDao;



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
        List<UserDto> userDtoByUser = userService.createUserDtoByUser(userList);
        Integer code = userDtoByUser != null ? Code.GET_OK : Code.GET_ERR;
        String msg = userDtoByUser != null ? "数据查询成功" : "数据查询失败";
        return  new Result(code,userDtoByUser,msg);
    }

    @ApiOperation(value = "用户登陆", notes = "用户登陆")
    @ApiImplicitParam(name = "LoginUserDto", value = "用户Dto", required = true, dataType = "json",paramType = "post")
    @PostMapping("/{identity}")
    public Result login(@RequestBody LoginUserDto loginUserDto,@PathVariable Integer identity){
        HttpSession session = request.getSession();
        User user1 = null;
        AdUser user2 = null;
        if(identity == 1){
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getUserAccount,loginUserDto.getUserAccount())
                    .eq(User::getUserPassword,loginUserDto.getUserPassword());
            user1 = userDao.selectOne(queryWrapper);

            LambdaQueryWrapper<Classes> qw = new LambdaQueryWrapper<>();
            qw.eq(Classes::getClassId, user1.getClassId());
            Classes classes = classesDao.selectOne(qw);


            UserPo userPo = User.toUserPO(user1);
            userPo.setClassName(classes.getClassName());
            session.setAttribute("user", userPo);

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
    @GetMapping("/session/{identity}")
    public Result getSession(@PathVariable int identity){
        if(identity == 1) {
            HttpSession session = request.getSession();
            UserPo user = (UserPo) session.getAttribute("user");
            return new Result(001, user, "session获取成功");
        } else {
            HttpSession session =request.getSession();
            AdUser user = (AdUser) session.getAttribute("user");
            return new Result(002, user, "session获取成功");
        }
    }

    @ApiOperation(value = "根据管理员ID获取用户信息", notes = "根据管理员ID获取用户信息")
    @ApiImplicitParam(name = "adId", value = "管理员ID", required = true, dataType = "Long",paramType = "path")
    @GetMapping("/adId/{adId}")
    public Result getUserByAdId(@PathVariable Long adId){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAdId,adId);
        List<User> users = userDao.selectList(queryWrapper);
        List<UserPo> userPos = new ArrayList<>();
        for(User user : users) {
            UserPo userPo = User.toUserPO(user);
            userPos.add(userPo);
        }
        Integer code = userPos != null ? Code.GET_OK : Code.GET_ERR;
        String msg = userPos != null ? "数据查询成功" : "数据查询失败";
        return new Result(code,userPos,msg);
    }

    @ApiOperation(value = "导入用户", notes = "导入用户")
    @ApiImplicitParam(name = "file", value = "用户表格", required = true, dataType = "excle",paramType = "post")
    @PostMapping("/import")
    public void importUserByFile(@RequestParam("file")MultipartFile file){

        userService.importUser(file);
    }

    @GetMapping("/condition")
    @ApiOperation(value = "根据条件查询用户", notes = "根据专业、班级、单位查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "major", value = "专业", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "className", value = "班级", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "unit", value = "单位", dataType = "String", paramType = "query")
    })
    public Result getUserByCondition(@RequestParam(required = false) String major,
                                     @RequestParam(required = false) String className,
                                     @RequestParam(required = false) String unit){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(major != null) {
            lambdaQueryWrapper.eq(User::getMajor,major);
        }
        if(unit != null) {
            lambdaQueryWrapper.eq(User::getUnit,unit);
        }
        if(className != null) {
            Classes classes = classesDao.getByClassName(className);
            lambdaQueryWrapper.eq(User::getClassId,classes.getClassId());
        }
        List<User> userList = userDao.selectList(lambdaQueryWrapper);

        List<UserDto> userDtoByUser = userService.createUserDtoByUser(userList);
        Integer code = userDtoByUser != null ? Code.GET_OK : Code.GET_ERR;
        String msg = userDtoByUser != null ? "数据查询成功" : "数据查询失败";
        return new Result(code,userDtoByUser,msg);
    }

}

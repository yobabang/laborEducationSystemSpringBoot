package com.flex.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flex.dao.AdUserDao;
import com.flex.dao.ClassesDao;
import com.flex.dao.UserDao;
import com.flex.domain.AdUser;
import com.flex.domain.Classes;
import com.flex.domain.User;
import com.flex.pojo.dto.UserDto;
import com.flex.pojo.dto.UserImportDto;
import com.flex.pojo.po.UserPo;
import com.flex.service.ListPlanService;
import com.flex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIpml implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ClassesDao classesDao;

    @Autowired
    private AdUserDao adUserDao;

    @Autowired
    private ListPlanService listPlanService;

    @Override
    public boolean save(User user) {
        return userDao.save(user) > 0;
    }

    @Override
    public boolean update(User user) {
        return userDao.updata(user) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id) > 0;
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User login(String userAccount, String userPassword) {
        return userDao.select(userAccount,userPassword);
    }

    @Override
    public UserPo selectByUserID(Long id) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserId,id);
        return User.toUserPO(userDao.selectOne(queryWrapper));
    }

    @Override
    public void importUser(MultipartFile file) {
        try{
            EasyExcel.read(file.getInputStream(), UserImportDto.class,new PageReadListener<UserImportDto>((dataList)->{
                dataList.forEach(item->{
                    Classes classes = classesDao.getByClassName(item.getClassName());
                    AdUser adUser = adUserDao.getAdUserByAdName(item.getAdName());

                    int imtype = 0;
                    if (item.getType() == "专升本" ){
                        imtype = 2;
                    }else{
                        imtype = 1;
                    }

                    User user = User.builder()
                            .userId(item.getUserId())
                            .userName(item.getUserName())
                            .userAccount(String.valueOf(item.getUserId()))
                            .userPassword(String.valueOf(item.getUserId()))
                            .userAlter(0)
                            .unit(item.getUnit())
                            .grade(item.getGrade())
                            .major(item.getMajor())
                            .classId(Math.toIntExact(classes.getClassId()))
                            .phone(item.getPhone())
                            .politics(item.getPolitics())
                            .email(item.getEmail())
                            .type(imtype)
                            .adId(adUser.getAdId())
                            .build();
                    userDao.insert(user);
                    listPlanService.createPlanByUserId(user);
                });
            }))
                    .headRowNumber(4)
                    .sheet()
                    .doRead();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<UserDto> createUserDtoByUser(List<User> users) {
        return users.stream()
                .map(item -> {
                    Classes classes = classesDao.getByClassId(item.getClassId());
                    AdUser adUser = adUserDao.getByAdId(item.getAdId());
                    String typeName = (item.getType() == 1) ? "本科" : "专升本";

                    return UserDto.builder()
                            .userId(item.getUserId())
                            .userName(item.getUserName())
                            .unit(item.getUnit())
                            .grade(item.getUnit())
                            .major(item.getMajor())
                            .className(classes.getClassName())
                            .politics(item.getPolitics())
                            .phone(item.getPhone())
                            .email(item.getEmail())
                            .typeName(typeName)
                            .adName(adUser.getAdName())
                            .build();
                })
                .collect(Collectors.toList());
    }
}

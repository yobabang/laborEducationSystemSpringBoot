package com.flex.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flex.dao.ClassesDao;
import com.flex.dao.UserDao;
import com.flex.domain.User;
import com.flex.pojo.dto.UserImportDto;
import com.flex.pojo.po.UserPo;
import com.flex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceIpml implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ClassesDao classesDao;

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
        System.out.println("进入service层");
        try{
            EasyExcel.read(file.getInputStream(), UserImportDto.class,new PageReadListener<UserImportDto>((dataList)->{
                dataList.forEach(item->{
                    User user = User.builder()
                            .userId(item.getUserId())
                            .userName(item.getUserName())
                            .unit(item.getUnit())
                            .grade(item.getGrade())
                            .major(item.getMajor())
                            .classId(item.getClassId())
                            .phone(item.getPhone())
                            .email(item.getEmail())
                            .type(item.getType())
                            .build();
                    System.out.println("输出user"+user);
                    userDao.save(user);
                });
            }))
                    .headRowNumber(1)
                    .sheet()
                    .doRead();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

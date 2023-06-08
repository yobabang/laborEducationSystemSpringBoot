package com.flex.service.impl;

import com.flex.dao.UserDao;
import com.flex.domain.User;
import com.flex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIpml implements UserService {
    @Autowired
    private UserDao userDao;

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
}

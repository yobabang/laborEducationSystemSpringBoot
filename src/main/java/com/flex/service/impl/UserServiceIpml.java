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

    public boolean save(User user) {
        return userDao.save(user) > 0;
    }

    public boolean update(User user) {
        return userDao.updata(user) > 0;
    }

    public boolean delete(Integer id) {
        return userDao.delete(id) > 0;
    }

    public User getById(Integer id) {
        return userDao.getById(id);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
}

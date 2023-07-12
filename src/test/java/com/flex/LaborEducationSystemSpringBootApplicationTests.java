package com.flex;

import com.flex.dao.AdUserDao;
import com.flex.dao.ListPlanDao;
import com.flex.dao.UserDao;
import com.flex.domain.ListPlan;
import com.flex.domain.User;
import com.flex.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LaborEducationSystemSpringBootApplicationTests {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AdUserDao adUserDao;

    @Test
    void contextLoads() {
        adUserDao.getClassById(23120101L);
    }

}

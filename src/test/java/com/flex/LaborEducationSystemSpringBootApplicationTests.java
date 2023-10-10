package com.flex;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.flex.dao.*;
import com.flex.domain.Assessment;
import com.flex.domain.ListPlan;
import com.flex.domain.Log;
import com.flex.domain.User;
import com.flex.pojo.vo.ClassFinishVo;
import com.flex.service.AssessmentService;
import com.flex.service.LogService;
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

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private AssessmentDao assessmentDao;

    @Autowired
    private LogService logService;

    @Autowired
    private LogDao logDao;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<Log> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Log::getLogId,1);
        Log log = logDao.selectOne(queryWrapper);
        logService.createLogFile(log);
    }

}

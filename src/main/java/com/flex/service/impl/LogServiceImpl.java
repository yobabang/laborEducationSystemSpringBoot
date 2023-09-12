package com.flex.service.impl;

import com.flex.dao.LogDao;
import com.flex.domain.Log;
import com.flex.domain.User;
import com.flex.pojo.dto.StudentLogScoreDto;
import com.flex.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public boolean save(Log log) {
        return logDao.save(log) > 0;
    }


    @Override
    public boolean delete(Integer id) {
        return logDao.delete(id) > 0;
    }

    @Override
    public Log getById(Integer id) {
        return logDao.getById(id);
    }

    @Override
    public List<Log> getAll() {
        return logDao.getAll();
    }

    @Override
    public List<Log> getLogByClassType(String className, Integer logType) {
        return logDao.getLogByClassType(className,logType);
    }

    @Override
    public List<StudentLogScoreDto> getStuScoreByClass(String className) {
        return logDao.getStuScoreByClass(className);
    }

    @Override
    public void createLogByUserId(User user) {

    }


}

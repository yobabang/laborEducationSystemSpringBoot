package com.flex.service.impl;

import com.flex.dao.PracticeDao;
import com.flex.domain.Practice;
import com.flex.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PracticeServiceImpl implements PracticeService {
    @Autowired
    private PracticeDao practiceDao;

    @Override
    public List<Practice> getByClass(String className) {
        return practiceDao.getByClass(className);
    }
}

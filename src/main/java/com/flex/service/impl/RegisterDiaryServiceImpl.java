package com.flex.service.impl;

import com.flex.dao.RegisterDiraryDao;
import com.flex.domain.RegisterDirary;
import com.flex.service.RegisterDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterDiaryServiceImpl implements RegisterDiaryService {
    @Autowired
    private RegisterDiraryDao registerDiraryDao;

    @Override
    public List<RegisterDirary> getByClass(String className) {
        return registerDiraryDao.getByClass(className);
    }
}

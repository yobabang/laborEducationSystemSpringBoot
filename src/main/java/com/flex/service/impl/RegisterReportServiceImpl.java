package com.flex.service.impl;

import com.flex.dao.RegisterReportDao;
import com.flex.domain.RegisterReport;
import com.flex.service.RegisterReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterReportServiceImpl implements RegisterReportService {
    @Autowired
    private RegisterReportDao registerReportDao;

    @Override
    public boolean save(RegisterReport registerReport) {
        return registerReportDao.save(registerReport) > 0;
    }

    @Override
    public boolean update(RegisterReport registerReport) {
        return registerReportDao.updata(registerReport) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return registerReportDao.delete(id) > 0;
    }

    @Override
    public RegisterReport getById(Integer id) {
        return registerReportDao.getById(id);
    }

    @Override
    public List<RegisterReport> getAll() {
        return registerReportDao.getAll();
    }

    @Override
    public List<RegisterReport> getByClasses(String className) {
        return registerReportDao.getByClasses(className);
    }
}

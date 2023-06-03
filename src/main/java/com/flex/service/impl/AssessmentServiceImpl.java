package com.flex.service.impl;

import com.flex.dao.AssessmentDao;
import com.flex.domain.Assessment;
import com.flex.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {
    @Autowired
    private AssessmentDao assessmentDao;

    @Override
    public boolean save(Assessment assessment) {
        return assessmentDao.save(assessment) > 0;
    }

    @Override
    public boolean update(Assessment assessment) {
        return assessmentDao.updata(assessment) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return assessmentDao.delete(id) > 0;
    }

    @Override
    public Assessment getById(Integer id) {
        return assessmentDao.getById(id);
    }

    @Override
    public List<Assessment> getAll() {
        return assessmentDao.getAll();
    }
}

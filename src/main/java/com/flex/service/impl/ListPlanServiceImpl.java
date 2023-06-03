package com.flex.service.impl;

import com.flex.dao.ListPlanDao;
import com.flex.domain.ListPlan;
import com.flex.service.ListPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPlanServiceImpl implements ListPlanService {
    @Autowired
    private ListPlanDao listPlanDao;

    @Override
    public boolean save(ListPlan listPlan) {
        return listPlanDao.save(listPlan) > 0;
    }

    @Override
    public boolean update(ListPlan listPlan) {
        return listPlanDao.updata(listPlan) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return listPlanDao.delete(id) > 0;
    }

    @Override
    public ListPlan getById(Integer id) {
        return listPlanDao.getById(id);
    }

    @Override
    public List<ListPlan> getAll() {
        return listPlanDao.getAll();
    }
}

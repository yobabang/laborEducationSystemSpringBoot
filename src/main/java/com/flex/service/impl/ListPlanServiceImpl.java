package com.flex.service.impl;

import com.flex.dao.ListPlanDao;
import com.flex.domain.ListPlan;
import com.flex.domain.Log;
import com.flex.domain.User;
import com.flex.pojo.vo.ClassFinishVo;
import com.flex.service.ListPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public ClassFinishVo getPlanByClassType(String listClass, Integer listType) {
        return listPlanDao.getPlanByClassType(listClass,listType);
    }

    @Override
    public void createPlanByUserId(User user) {
        for (int i = 1; i < 4; i++) {
            ListPlan listPlan = ListPlan.builder()
                    .listType(i)
                    .listTime(LocalDateTime.now())
                    .listUnit(user.getUnit())
                    .listGrade(user.getGrade())
                    .listMajor(user.getMajor())
                    .listClass(String.valueOf(user.getClassId()))
                    .userId(user.getUserId())
                    .noticeId(Long.valueOf(i))
                    .listState(0)
                    .build();
            listPlanDao.insert(listPlan);
        }
    }
}

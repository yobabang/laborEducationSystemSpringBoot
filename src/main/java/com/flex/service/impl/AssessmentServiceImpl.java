package com.flex.service.impl;

import com.alibaba.excel.EasyExcel;
import com.flex.dao.AssessmentDao;
import com.flex.domain.Assessment;
import com.flex.service.AssessmentService;
import com.flex.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createAssessmentFile(List<Assessment> assessments,String unit) {
        try {
            String filePath = "./file/Assessment_" + unit + ".xlsx";
            // 定义表头数据
            List<List<String>> head = new ArrayList<>();
            head.add(Arrays.asList("评分表编号"));
            head.add(Arrays.asList("姓名"));
            head.add(Arrays.asList("学号"));
            head.add(Arrays.asList("班级"));
            head.add(Arrays.asList("专业"));
            head.add(Arrays.asList("学院"));
            head.add(Arrays.asList("辅导员"));
            head.add(Arrays.asList("管理部门"));
            head.add(Arrays.asList("日志得分"));
            head.add(Arrays.asList("报告得分"));
            head.add(Arrays.asList("成绩评定"));
            head.add(Arrays.asList("意见"));


            List<List<Object>> data = new ArrayList<>();
            for (Assessment ass : assessments
            ) {
                List<Object> rowData = new ArrayList<>();
                rowData.add(ass.getAssId());
                rowData.add(ass.getAssName());
                rowData.add(ass.getUserId());
                rowData.add(ass.getClassId());
                rowData.add(ass.getAssMajor());
                rowData.add(ass.getAssUnit());
                rowData.add(ass.getAdId());
                rowData.add(ass.getAssDep());
                rowData.add(ass.getAssLog());
                rowData.add(ass.getAssReport());
                rowData.add(ass.getAssGrade());
                data.add(rowData);
            }
            EasyExcel.write(filePath).head(head).sheet("Sheet1").doWrite(data);
            throw new RuntimeException("Something went wrong");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

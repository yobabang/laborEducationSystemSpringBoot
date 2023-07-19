package com.flex.service;

import com.flex.domain.Practice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PracticeService {

    /**
     * 根据班级查询
     * @param className
     * @return
     */
    public List<Practice> getByClass(String className);
}

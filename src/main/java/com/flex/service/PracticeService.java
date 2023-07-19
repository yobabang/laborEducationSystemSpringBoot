package com.flex.service;

import com.flex.domain.Practice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PracticeService {

    /**
     * 根据班级查询
     * @param className
     * @return
     */
    public List<Practice> getByClass(String className);
}

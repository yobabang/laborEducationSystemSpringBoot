package com.flex.service;

import com.flex.domain.RegisterDirary;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RegisterDiaryService {

    /**
     * 根据班级查询
     * @param className
     * @return
     */
    public List<RegisterDirary> getByClass(String className);
}

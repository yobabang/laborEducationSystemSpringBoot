package com.flex.service;

import com.flex.domain.Log;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface LogService {

    /**
     * 保存
     * @param log
     * @return
     */
    public boolean save(Log log);

    /**
     * 修改
     * @param log
     * @return
     */
    public boolean update(Log log);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Log getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Log> getAll();

    /**
     * 根据班级名称和日志类型查询
     * @param className
     * @param logType
     * @return
     */
    public List<Log> getLogByClassType(String className,Integer logType);


}

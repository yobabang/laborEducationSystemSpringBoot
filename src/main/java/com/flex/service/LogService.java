package com.flex.service;

import com.flex.domain.Log;
import com.flex.domain.User;
import com.flex.pojo.dto.StudentLogScoreDto;
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

    /**
     * 根据班级查询总成绩
     * @param className
     * @return
     */
    public List<StudentLogScoreDto> getStuScoreByClass(String className);

    /**
     * 按学号创建日志
     * @param user
     */
    public void createLogByUserId(User user);

    /**
     *  导出日志文件
     * @param log
     */
    public String createLogFile(Log log);
}

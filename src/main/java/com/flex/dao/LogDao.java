package com.flex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flex.domain.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LogDao extends BaseMapper<Log>{
    @Insert("INSERT INTO log (log_id, log_type, U_type, log_name, log_unit, log_classes, log_content, location, log_process, effect, result, log_time, log_score, log_state, log_mark) " +
            "VALUES (#{logId}, #{logType}, #{UType}, #{logName}, #{logUnit}, #{logClasses}, #{logContent}, #{location}, #{logProcess}, #{effect}, #{result}, #{logTime}, #{logScore}, #{logState}, #{logMark})")
    public int save(Log log);

    @Delete("DELETE FROM log WHERE user_id = #{id}")
    public int delete(Integer id);

    @Select("select * from log where user_id = #{id}")
    public Log getById(Integer id);

    @Select("select * from log")
    public List<Log> getAll();

    @Select("select * from log where log_classes = #{className} and log_type = #{logType}")
    public List<Log> getLogByClassType(String className,Integer logType);
}

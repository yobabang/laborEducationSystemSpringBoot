package com.flex.dao;

import com.flex.domain.Log;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LogDao {
    @Insert("INSERT INTO log (log_id, log_type, U_type, log_name, log_unit, log_classes, log_content, location, log_process, effect, result, log_time, log_score, log_state, log_mark) " +
            "VALUES (#{logId}, #{logType}, #{UType}, #{logName}, #{logUnit}, #{logClasses}, #{logContent}, #{location}, #{logProcess}, #{effect}, #{result}, #{logTime}, #{logScore}, #{logState}, #{logMark})")
    public int save(Log log);

    @Update("UPDATE log SET log_type = #{logType}, U_type = #{UType}, log_name = #{logName}, log_unit = #{logUnit}, log_classes = #{logClasses}, log_content = #{logContent}, location = #{location}, log_process = #{logProcess}, effect = #{effect}, result = #{result}, log_time = #{logTime}, log_score = #{logScore}, log_state = #{logState}, log_mark = #{logMark} WHERE log_id = #{logId}")
    public int updata(Log log);

    @Delete("DELETE FROM log WHERE user_id = #{id}")
    public int delete(Integer id);

    @Select("select * from log where user_id = #{id}")
    public Log getById(Integer id);

    @Select("select * from log")
    public List<Log> getAll();
}

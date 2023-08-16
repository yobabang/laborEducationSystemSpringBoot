package com.flex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flex.domain.Log;
import com.flex.pojo.dto.StudentLogScoreDto;
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

    @Select("SELECT user_name, class_name, user_id, daily_score, service_score, production_score,\n" +
            "    (daily_weighted_score + service_weighted_score + production_weighted_score) AS total_weighted_score\n" +
            "FROM (\n" +
            "    SELECT u.user_name, c.class_name, u.user_id,\n" +
            "        l1.log_score AS daily_score,\n" +
            "        l2.log_score AS service_score,\n" +
            "        l3.log_score AS production_score,\n" +
            "        ROUND(l1.log_score * w.daily_weight) AS daily_weighted_score,\n" +
            "        ROUND(l2.log_score * w.service_weight) AS service_weighted_score,\n" +
            "        ROUND(l3.log_score * w.production_weight) AS production_weighted_score\n" +
            "    FROM user u\n" +
            "    INNER JOIN classes c ON u.class_id = c.class_id\n" +
            "    LEFT JOIN log l1 ON u.user_id = l1.user_id AND l1.log_type = 1\n" +
            "    LEFT JOIN log l2 ON u.user_id = l2.user_id AND l2.log_type = 2\n" +
            "    LEFT JOIN log l3 ON u.user_id = l3.user_id AND l3.log_type = 3\n" +
            "    INNER JOIN weight w ON u.grade = w.grade\n" +
            "    WHERE c.class_name = #{className}\n" +
            ") AS weighted_scores;")
    public List<StudentLogScoreDto> getStuScoreByClass(String className);
}

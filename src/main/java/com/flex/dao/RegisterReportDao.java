package com.flex.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flex.domain.RegisterReport;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegisterReportDao extends BaseMapper<RegisterReport> {
    @Insert("INSERT INTO register_report (report_id, report, report_time, report_state, report_score, report_mark) " +
            "VALUES (#{reportId}, #{report}, #{reportTime}, #{reportState}, #{reportScore}, #{reportMark})")
    public int save(RegisterReport user);

    @Delete("DELETE FROM register_report WHERE report_id = #{id}")
    public int delete(Integer id);

    @Select("select * from register_report where report_id = #{id}")
    public RegisterReport getById(Integer id);

    @Select("select * from register_report")
    public List<RegisterReport> getAll();

    @Select("select * from register_report,user,classes where user.user_id = register_report.user_id and user.class_id = classes.class_id and classes.class_name = #{className}")
    public List<RegisterReport> getByClasses(String className);
}

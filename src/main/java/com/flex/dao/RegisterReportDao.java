package com.flex.dao;


import com.flex.domain.RegisterReport;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RegisterReportDao {
    @Insert("INSERT INTO register_report (report_id, report, report_time, report_state, report_score, report_mark) " +
            "VALUES (#{reportId}, #{report}, #{reportTime}, #{reportState}, #{reportScore}, #{reportMark})")
    public int save(RegisterReport user);

    @Update("UPDATE register_report SET report = #{report}, report_time = #{reportTime}, report_state = #{reportState}, report_score = #{reportScore}, report_mark = #{reportMark} WHERE report_id = #{reportId}")
    public int updata(RegisterReport user);

    @Delete("DELETE FROM register_report WHERE report_id = #{id}")
    public int delete(Integer id);

    @Select("select * from register_report where report_id = #{id}")
    public RegisterReport getById(Integer id);

    @Select("select * from register_report")
    public List<RegisterReport> getAll();

}

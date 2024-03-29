package com.flex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flex.domain.ListPlan;
import com.flex.pojo.vo.ClassFinishVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ListPlanDao extends BaseMapper<ListPlan> {
    @Insert("INSERT INTO list_plan(list_id, list_name, list_time, list_unit, list_grade) " +
            "VALUES (#{listId}, #{listName}, #{listTime}, #{listUnit}, #{listGrade})")
    public int save(ListPlan listPlan);

    @Update("UPDATE list_plan SET list_name = #{listName}, list_time = #{listTime}, list_unit = #{listUnit}, list_grade = #{listGrade} WHERE list_id = #{listId}")
    public int updata(ListPlan listPlan);

    @Delete("DELETE FROM list_plan WHERE list_id = #{id}")
    public int delete(Integer id);

    @Select("select * from list_plan where list_id = #{id}")
    public ListPlan getById(Integer id);

    @Select("select * from list_plan")
    public List<ListPlan> getAll();

    @Select("select COUNT(*) AS total_count,\n" +
            "SUM(CASE WHEN list_state = 1 THEN 1 ELSE 0 END) AS state1_count,\n" +
            "SUM(CASE WHEN list_state = 3 THEN 1 ELSE 0 END) AS state3_count,\n" +
            "COUNT(*)-SUM(CASE WHEN list_state = 1 THEN 1 ELSE 0 END)-SUM(CASE WHEN list_state = 3 THEN 1 ELSE 0 END) AS state0_count,\n" +
            "list_time,\n" +
            "list_type\n" +
            "FROM list_plan\n" +
            "WHERE list_class = #{listClass} AND list_type = #{listType}")
    public ClassFinishVo getPlanByClassType(String listClass,Integer listType);
}

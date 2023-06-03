package com.flex.dao;

import com.flex.domain.Assessment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AssessmentDao {
    @Insert("INSERT INTO assessment(ass_id, ass_name, ass_number, ass_classes, ass_major, ass_unit, ass_instructor, ass_grade) " +
            "VALUES (#{assId}, #{assName}, #{assNumber}, #{assClasses}, #{assMajor}, #{assUnit}, #{assInstructor}, #{assGrade})")
    public int save(Assessment blog);

    @Update("UPDATE assessment SET ass_name = #{assName}, ass_number = #{assNumber}, ass_classes = #{assClasses}, ass_major = #{assMajor}, " +
            "ass_unit = #{assUnit}, ass_instructor = #{assInstructor}, ass_grade = #{assGrade} WHERE ass_id = #{assId}")
    public int updata(Assessment blog);

    @Delete("DELETE FROM assessment WHERE list_id = #{id}")
    public int delete(Integer id);

    @Select("select * from assessment where list_id = #{id}")
    public Assessment getById(Integer id);

    @Select("select * from assessment")
    public List<Assessment> getAll();
}


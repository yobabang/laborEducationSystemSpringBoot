package com.flex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flex.domain.Classes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClassesDao extends BaseMapper<Classes> {

    @Select("Select * from classes where class_name = #{className}")
    public Classes getByClassName(String className);

    @Select("Select * from classes where class_id = #{id}")
    public Classes getByClassId(int id);
}

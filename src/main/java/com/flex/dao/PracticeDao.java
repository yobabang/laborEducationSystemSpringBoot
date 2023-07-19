package com.flex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flex.domain.Practice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PracticeDao extends BaseMapper<Practice> {
    @Select("select * from practice,user,classes where user.user_id = practice.user_id and user.class_id = classes.class_id and classes.class_name = #{className}")
    public List<Practice> getByClass(String className);
}

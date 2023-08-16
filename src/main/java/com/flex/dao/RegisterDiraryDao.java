package com.flex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flex.domain.RegisterDirary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegisterDiraryDao extends BaseMapper<RegisterDirary> {

    @Select("select * from user,classes,register_diary where user.user_id = register_diary.user_id and user.class_id = classes.class_id and classes.class_name = #{className}")
    public List<RegisterDirary> getByClass(String className);
}

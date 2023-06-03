package com.flex.dao;


import com.flex.domain.Register;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegisterDao {
    @Insert("INSERT INTO register (registerid, undergraduate_type, user_name, classes, college, id_number, sex, start_time, end_time, `form`, instructor, project, unit, register_location, head, phone_number, email, item, status, major, object_introduction, register_log) " +
            "VALUES (#{registerId}, #{undergraduateType}, #{userName}, #{classes}, #{college}, #{idNumber}, #{sex}, #{startTime}, #{endTime}, #{form}, #{instructor}, #{project}, #{unit}, #{registerLocation}, #{head}, #{phoneNumber}, #{email}, #{item}, #{status}, #{major}, #{objectIntroduction}, #{registerLog})")
    public int save(Register register);

    @Insert("INSERT INTO register (register_id, u_type, register_name, register_classes, register_unit, register_number, politics, start_time, end_time, form, instructor, project, pra_unit, register_location, unit_attribute, head, head_phone, head_email, item, register_status, unit_major, obj_intro, register_log_time, register_log, register_state, register_mark) " +
            "VALUES (#{registerId}, #{uType}, #{registerName}, #{registerClasses}, #{registerUnit}, #{registerNumber}, #{politics}, #{startTime}, #{endTime}, #{form}, #{instructor}, #{project}, #{praUnit}, #{registerLocation}, #{unitAttribute}, #{head}, #{headPhone}, #{headEmail}, #{item}, #{registerStatus}, #{unitMajor}, #{objIntro}, #{registerLogTime}, #{registerLog}, #{registerState}, #{registerMark})")
    public int updata(Register register);

    @Delete("DELETE FROM register WHERE register_id = #{id}")
    public int delete(Integer id);

    @Select("select * from register where register_id = #{id}")
    public Register getById(Integer id);

    @Select("select * from register")
    public List<Register> getAll();
}

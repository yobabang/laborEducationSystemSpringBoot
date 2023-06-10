package com.flex.dao;

import com.flex.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Insert("INSERT INTO user (user_id, user_name, user_account, user_password, obj, alter_sign, id_number, unit, grade, major, classes, phone, email, remark) " +
            "VALUES (#{userId}, #{userName}, #{userAccount}, #{userPassword}, #{obj}, #{alterSign}, #{idNumber}, #{unit}, #{grade}, #{major}, #{classes}, #{phone}, #{email}, #{remark})")
    public int save(User user);

    @Update("UPDATE user SET user_name = #{userName}, user_account = #{userAccount}, user_password = #{userPassword}, obj = #{obj}, alter_sign = #{alterSign}, id_number = #{idNumber}, unit = #{unit}, grade = #{grade}, major = #{major}, classes = #{classes}, phone = #{phone}, email = #{email}, remark = #{remark} WHERE user_id = #{userId}")
    public int updata(User user);

    @Delete("DELETE FROM user WHERE user_id = #{id}")
    public int delete(Integer id);

    @Select("select * from user where user_id = #{id}")
    public User getById(Integer id);

    @Select("select * from user")
    public List<User> getAll();

    @Select("select * from user where user_account = #{userAccount} and user_password = #{userPassword}")
    public User select(String userAccount,String userPassword);


}


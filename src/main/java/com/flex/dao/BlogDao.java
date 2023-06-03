package com.flex.dao;

import com.flex.domain.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogDao {
    @Insert("INSERT INTO blog(blog_id, blog_title, blog_content, au_name, release_time, label, blog_read, likes, comments, file_add, blog_state, save_time) " +
            "VALUES (#{blogId}, #{blogTitle}, #{blogContent}, #{auName}, #{releaseTime}, #{label}, #{blogRead}, #{likes}, #{comments}, #{fileAdd}, #{blogState}, #{saveTime})")
    public int save(Blog blog);

    @Update("UPDATE blog SET blog_title = #{blogTitle}, blog_content = #{blogContent}, au_name = #{auName}, release_time = #{releaseTime}, label = #{label}, " +
            "blog_read = #{blogRead}, likes = #{likes}, comments = #{comments}, file_add = #{fileAdd}, blog_state = #{blogState}, save_time = #{saveTime} WHERE blog_id = #{blogId}")
    public int updata(Blog blog);

    @Delete("DELETE FROM blog WHERE list_id = #{id}")
    public int delete(Integer id);

    @Select("select * from blog where list_id = #{id}")
    public Blog getById(Integer id);

    @Select("select * from blog")
    public List<Blog> getAll();
}

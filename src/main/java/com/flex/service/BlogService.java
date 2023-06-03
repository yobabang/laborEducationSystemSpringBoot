package com.flex.service;

import com.flex.domain.Blog;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BlogService {
    /**
     * 保存
     * @param blog
     * @return
     */
    public boolean save(Blog blog);

    /**
     * 修改
     * @param blog
     * @return
     */
    public boolean update(Blog blog);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Blog getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Blog> getAll();
}

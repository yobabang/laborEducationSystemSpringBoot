package com.flex.service.impl;

import com.flex.dao.BlogDao;
import com.flex.domain.Blog;
import com.flex.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Override
    public boolean save(Blog blog) {
        return blogDao.save(blog) > 0;
    }

    @Override
    public boolean update(Blog blog) {
         return blogDao.updata(blog) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return blogDao.delete(id) > 0;
    }

    @Override
    public Blog getById(Integer id) {
        return blogDao.getById(id);
    }

    @Override
    public List<Blog> getAll() {
        return blogDao.getAll();
    }
}

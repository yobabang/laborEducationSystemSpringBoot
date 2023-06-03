package com.flex.controller;

import com.flex.domain.Blog;
import com.flex.service.BlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
@Api(tags = "博客管理")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "添加博客", notes = "添加博客信息")
    @PostMapping
    public Result save(@RequestBody Blog blog){
        boolean flag = blogService.save(blog);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @ApiOperation(value = "更新博客", notes = "更新博客信息")
    @PutMapping
    public Result updata(@RequestBody Blog blog){
        boolean flag = blogService.update(blog);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @ApiOperation(value = "删除博客", notes = "根据博客ID删除博客信息")
    @ApiImplicitParam(name = "blogId", value = "博客ID", required = true, dataType = "Integer",paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        boolean flag = blogService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @ApiOperation(value = "查询博客", notes = "根据博客ID查询博客信息")
    @ApiImplicitParam(name = "blogId", value = "博客ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Blog blog = blogService.getById(id);
        Integer code = blog != null ? Code.GET_OK : Code.GET_ERR;
        String msg = blog != null ? "" : "数据查询失败";
        return  new Result(code,blog,msg);
    }

    @ApiOperation(value = "获取所有博客信息", notes = "获取所有博客信息")
    @GetMapping
    public Result getAll(){
        List<Blog> blogs = blogService.getAll();
        Integer code = blogs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = blogs != null ? "" : "数据查询失败";
        return new Result(code,blogs,msg);
    }
}

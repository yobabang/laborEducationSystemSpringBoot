package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.flex.dao.NoticeDao;
import com.flex.domain.Notice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
@Api(tags = "通知管理")
public class NoticeController {
    @Autowired
    private NoticeDao noticeDao;

    @ApiOperation(value = "添加通知", notes = "添加通知")
    @PostMapping
    public Result save(@RequestBody Notice notice){
        Integer code;
        String msg;
        int insert = noticeDao.insert(notice);
        if (insert == 1 ){
            code = Code.SAVE_OK;
            msg = "添加成功";
        }else{
            code = Code.SAVE_ERR;
            msg = "添加失败";
        }
        return new Result(code,msg);
    }

    @ApiOperation(value = "获取用户通知", notes = "根据接受用户ID获取用户通知")
    @ApiImplicitParam(name = "userId", value = "接受用户ID", required = true, dataType = "String",paramType = "path")
    @GetMapping("/{userId}")
    public Result getById(@PathVariable Long userId){
        try {
            QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", userId);
            List<Notice> notices = noticeDao.selectList(queryWrapper);

            Integer code = notices != null ? Code.GET_OK : Code.GET_ERR;
            String msg = notices != null ? "数据查询成功" : "数据查询失败";
            return new Result(code, notices, msg);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(5001, null, "数据查询报错");
        }

    }
}

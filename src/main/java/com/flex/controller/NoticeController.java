package com.flex.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
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
    @ApiImplicitParam(name = "noticeReceiver", value = "接受用户ID", required = true, dataType = "Integer",paramType = "path")
    @GetMapping("/{noticeReceiver}")
    public Result getById(@PathVariable Integer noticeReceiver){
        LambdaQueryWrapper<Notice> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Notice::getNoticeReceiver, noticeReceiver);
        List<Notice> notices = noticeDao.selectList(queryWrapper);

        if (CollectionUtils.isEmpty(notices)) {
            return new Result(Code.GET_ERR, null, "数据查询失败");
        } else {
            return new Result(Code.GET_OK, notices, "数据查询成功");
        }
    }
}

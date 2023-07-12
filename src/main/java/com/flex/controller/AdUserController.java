package com.flex.controller;


import com.flex.dao.AdUserDao;
import com.flex.pojo.vo.AdClassVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aduser")
@Api(tags = "管理员接口")
public class AdUserController {
    @Autowired
    private AdUserDao adUserDao;

    @ApiOperation(value = "查询班级", notes = "根据工号查询班级")
    @ApiImplicitParam(name = "ad_id", value = "工号", required = true, dataType = "Long",paramType = "path")
    @GetMapping("{ad_id}")
    public Result getClassById(@PathVariable Long ad_id){

        List<AdClassVo> classById = adUserDao.getClassById(ad_id);
        return new Result(Code.GET_OK,classById,"数据查询成功");
    }
}

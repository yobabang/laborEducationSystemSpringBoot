package com.flex.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flex.domain.AdUser;
import com.flex.pojo.vo.AdClassVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdUserDao extends BaseMapper<AdUser> {

    /**
     * 根据ad_id查询班级
     * @param id
     * @return
     */
    @Select("SELECT ad.ad_id, c.class_name\n" +
            "FROM class_ad ca\n" +
            "INNER JOIN ad_user ad ON ca.ad_id = ad.ad_id\n" +
            "INNER JOIN classes c ON ca.class_id = c.class_id\n" +
            "WHERE ca.ad_id = #{id}")
    public List<AdClassVo> getClassById(Long id);

    /**
     * 根据姓名查询
     * @param adName
     * @return
     */
    @Select("select * from ad_user where ad_name = #{adName}")
    public AdUser getAdUserByAdName(String adName);

    @Select("select * from ad_user where ad_Id = #{id}")
    public AdUser getByAdId(Long id);
}

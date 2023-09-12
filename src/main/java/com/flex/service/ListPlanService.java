package com.flex.service;

import com.flex.domain.ListPlan;
import com.flex.domain.User;
import com.flex.pojo.vo.ClassFinishVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ListPlanService {
    /**
     * 保存
     * @param listPlan
     * @return
     */
    public boolean save(ListPlan listPlan);

    /**
     * 修改
     * @param listPlan
     * @return
     */
    public boolean update(ListPlan listPlan);

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
    public ListPlan getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<ListPlan> getAll();

    /**
     * 按班级和类型进行查询
     * @param listClass
     * @param listType
     * @return
     */
    public ClassFinishVo getPlanByClassType(String listClass, Integer listType);

    /**
     * 按学号创建计划
     * @param user
     */
    public void createPlanByUserId(User user);
}

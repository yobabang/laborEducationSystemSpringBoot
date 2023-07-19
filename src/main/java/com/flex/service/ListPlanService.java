package com.flex.service;

import com.flex.domain.ListPlan;
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
}

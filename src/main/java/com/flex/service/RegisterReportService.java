package com.flex.service;

import com.flex.domain.RegisterReport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RegisterReportService {
    /**
     * 保存
     * @param registerReport
     * @return
     */
    public boolean save(RegisterReport  registerReport);

    /**
     * 修改
     * @param registerReport
     * @return
     */
    public boolean update(RegisterReport registerReport);

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
    public RegisterReport getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<RegisterReport> getAll();
}

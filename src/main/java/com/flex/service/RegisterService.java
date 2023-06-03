package com.flex.service;

import com.flex.domain.Register;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RegisterService {
    /**
     * 保存
     * @param register
     * @return
     */
    public boolean save(Register register);

    /**
     * 修改
     * @param register
     * @return
     */
    public boolean update(Register register);

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
    public Register getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Register> getAll();
}

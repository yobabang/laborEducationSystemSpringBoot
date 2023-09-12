package com.flex.service;

import com.flex.domain.User;
import com.flex.pojo.po.UserPo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Transactional
public interface UserService {

    /**
     * 保存
     * @param user
     * @return
     */
    public boolean save(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    public boolean update(User user);

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
    public User getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<User> getAll();

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @return
     */
    public User login(String userAccount,String userPassword);

    /**
     * 根据用户id查询
     * @param id
     * @return
     */
    public UserPo selectByUserID(Long id);

    /**
     * 导入学生信息
     * @param file
     * @return
     */
    public void importUser(MultipartFile file);
}

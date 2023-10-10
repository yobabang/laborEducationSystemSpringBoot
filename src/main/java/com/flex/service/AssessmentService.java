package com.flex.service;

import com.flex.domain.Assessment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AssessmentService {
    /**
     * 保存
     * @param assessment
     * @return
     */
    public boolean save(Assessment assessment);

    /**
     * 修改
     * @param assessment
     * @return
     */
    public boolean update(Assessment assessment);

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
    public Assessment getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Assessment> getAll();

    /**
     * 生成成绩表文件
     */
    public String createAssessmentFile(List<Assessment> assessments,String unit);
}

package com.api.manage.dao.basicArchives;

import com.api.model.basicArchives.CpmDecoration;
import com.api.model.basicArchives.SearchDecoration;
import com.api.vo.basicArchives.VoDecoration;

import java.util.List;

public interface CpmDecorationDao {
    /**
     * 查询所有的装修信息（包含条件搜索）【装修表，楼栋表，单元表，房产表，住户表，住户房产关联表】
     * @param searchDecoration 装修信息搜索条件
     * @return 装修信息集合
     */
    List<VoDecoration> list(SearchDecoration searchDecoration);

    /**
     * 添加装修信息 【装修表】
     * @param cpmDecoration 装修信息
     * @return 影响行数
     */
    int insert(CpmDecoration cpmDecoration);

    /**
     * 更新装修信息 【装修表】
     * @param cpmDecoration 装修信息
     * @return 影响行数
     */
    int update(CpmDecoration cpmDecoration);

    /**
     * 根据id查询装修信息 【装修表】
     * @param id 装修主键id
     * @return 装修信息
     */
    CpmDecoration findById(Integer id);

    /**
     * 根据id删除装修信息
     * @param id 装修主键id
     * @return 影响行数
     */
    int deleteById(Integer id);
}
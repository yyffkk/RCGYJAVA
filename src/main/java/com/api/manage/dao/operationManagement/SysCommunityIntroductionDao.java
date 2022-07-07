package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchCommunityIntroduction;
import com.api.model.operationManagement.SysCommunityIntroduction;
import com.api.vo.operationManagement.VoCommunityIntroduction;
import com.api.vo.operationManagement.VoFBICommunityIntroduction;

import java.util.List;

public interface SysCommunityIntroductionDao {
    /**
     * 查询所有的社区介绍信息（包含条件搜索）
     * @param searchCommunityIntroduction 社区介绍搜索条件
     * @return 社区介绍信息
     */
    List<VoCommunityIntroduction> list(SearchCommunityIntroduction searchCommunityIntroduction);

    /**
     * 添加社区介绍信息
     * @param sysCommunityIntroduction 社区介绍model信息
     * @return 影响行数
     */
    int insert(SysCommunityIntroduction sysCommunityIntroduction);

    /**
     * 根据社区介绍主键Id查询社区介绍信息
     * @param id 社区介绍主键Id
     * @return 社区介绍信息
     */
    VoFBICommunityIntroduction findById(Integer id);

    /**
     * 修改社区介绍信息
     * @param sysCommunityIntroduction 社区介绍model信息
     * @return 影响行数
     */
    int update(SysCommunityIntroduction sysCommunityIntroduction);

    /**
     * 删除社区介绍信息
     * @param id 社区介绍主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 启用当前社区介绍模版
     * @param id 社区介绍主键id
     * @return 影响行数
     */
    int enable(Integer id);

    /**
     * 禁用其他社区介绍模版
     * @param id 社区介绍主键id
     * @return 影响行数
     */
    int disableOther(Integer id);
}

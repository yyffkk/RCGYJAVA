package com.api.dao.operationManagement;

import com.api.model.operationManagement.SearchSponsorManagement;
import com.api.model.operationManagement.SponsorManagement;
import com.api.vo.operationManagement.VoFindByIdSponsorManagement;
import com.api.vo.operationManagement.VoSponsorActivityDetail;
import com.api.vo.operationManagement.VoSponsorManagement;

import java.util.List;

public interface SysSponsorManagementDao {
    /**
     * 查询所有的主办方信息（包含条件搜索）
     * @param searchSponsorManagement 搜索条件
     * @return 主办方信息集合
     */
    List<VoSponsorManagement> list(SearchSponsorManagement searchSponsorManagement);

    /**
     * 添加主办方信息
     * @param sponsorManagement 主办方信息
     * @return 影响行数
     */
    int insert(SponsorManagement sponsorManagement);

    /**
     * 根据主键id查询主办方信息
     * @param id 主键id
     * @return 主办方信息
     */
    VoFindByIdSponsorManagement findById(Integer id);

    /**
     * 更新主办方信息
     * @param sponsorManagement 新主办方信息
     * @return 影响行数
     */
    int update(SponsorManagement sponsorManagement);

    /**
     * 假删除主办方信息
     * @param id 主键id
     * @return 影响行数
     */
    int falseDelete(int id);

    /**
     * 主办活动详情
     * @param id 主键id
     * @return 活动标题集合
     */
    List<VoSponsorActivityDetail> sponsorActivityDetail(Integer id);
}

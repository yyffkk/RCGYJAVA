package com.api.dao.operationManagement;

import com.api.model.operationManagement.SearchSponsorManagement;
import com.api.model.operationManagement.SponsorManagement;
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
}

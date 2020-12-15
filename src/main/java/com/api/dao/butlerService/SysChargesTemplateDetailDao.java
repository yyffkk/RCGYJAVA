package com.api.dao.butlerService;

import com.api.model.butlerService.SearchChargesTemplateDetail;
import com.api.model.butlerService.SysChargesTemplateDetail;
import com.api.vo.butlerService.VoChargesTemplateDetail;

import java.util.List;

public interface SysChargesTemplateDetailDao {
    /**
     * 根据物业收费标准模版主键id 查询所有的物业收费标准明细 (包含条件搜索)
     * @param searchChargesTemplateDetail 搜索条件
     * @return 物业收费标准明细集合
     */
    List<VoChargesTemplateDetail> list(SearchChargesTemplateDetail searchChargesTemplateDetail);

    /**
     * 添加物业收费标准明细信息
     * @param sysChargesTemplateDetail 物业收费标准明细信息
     * @return 影响行数
     */
    int insert(SysChargesTemplateDetail sysChargesTemplateDetail);
}

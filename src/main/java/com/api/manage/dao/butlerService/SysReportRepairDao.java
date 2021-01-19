package com.api.manage.dao.butlerService;

import com.api.model.butlerService.ReportRepair;
import com.api.model.butlerService.SearchReportRepair;
import com.api.vo.butlerService.VoFindByIdRepair;
import com.api.vo.butlerService.VoRepair;
import com.api.vo.butlerService.VoReportRepair;

import java.util.List;

public interface SysReportRepairDao {
    /**
     * 查询所有报事报修信息（包含条件搜索）
     * @param searchReportRepair 搜索条件
     * @return 报事报修信息集合
     */
    List<VoReportRepair> list(SearchReportRepair searchReportRepair);
    /**
     * 查询报修详情
     * @param id 工单主键id
     * @return 报修详情
     */
    VoRepair findRepairDetail(Integer id);

    /**
     * 添加报事报修信息
     * @param reportRepair 报事报修信息
     * @return 影响行数
     */
    int insert(ReportRepair reportRepair);

    /**
     * 根据报事报修主键id 查询报事报修信息
     * @param id 报事报修主键id
     * @return 报事报修 Vo findById 回显
     */
    VoFindByIdRepair findById(Integer id);

    /**
     * 修改报事报修信息
     * @param reportRepair 新报事报修信息
     * @return 影响行数
     */
    int update(ReportRepair reportRepair);
}

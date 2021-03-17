package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionCheckItems;
import com.api.model.butlerService.SysInspectionPoint;
import com.api.vo.butlerService.VoInspectionPoint;

import java.util.List;

public interface SysInspectionPointDao {
    /**
     * 查询所有的巡检点信息（包含条件搜索）
     * @param searchInspectionPoint 搜索条件
     * @return 巡检点信息集合
     */
    List<VoInspectionPoint> list(SearchInspectionPoint searchInspectionPoint);

    /**
     * 添加巡检点信息
     * @param sysInspectionPoint 巡检点model
     * @return 影响行数
     */
    int insert(SysInspectionPoint sysInspectionPoint);

    /**
     * 添加巡检点检查项
     * @param checkItems 巡检点检查项信息model
     * @return 影响行数
     */
    int insertCheckItems(SysInspectionCheckItems checkItems);
}

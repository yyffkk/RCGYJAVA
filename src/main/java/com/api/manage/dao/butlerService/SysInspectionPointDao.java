package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionCheckItems;
import com.api.model.butlerService.SysInspectionPoint;
import com.api.vo.butlerService.VoFBIInspectionCheckItems;
import com.api.vo.butlerService.VoFBIInspectionPoint;
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

    /**
     * 根据巡检点主键id查询巡检点信息
     * @param id 巡检点主键id
     * @return 巡检点信息
     */
    VoFBIInspectionPoint findById(Integer id);

    /**
     * 根据巡检点主键id 查询巡检点检查项信息
     * @param id 巡检点主键id
     * @return 巡检点检查项信息
     */
    List<VoFBIInspectionCheckItems> findByIdCheckItems(Integer id);

    /**
     * 更新巡检点信息
     * @param sysInspectionPoint 巡检点model
     * @return 影响行数
     */
    int update(SysInspectionPoint sysInspectionPoint);

    /**
     * 删除巡检点选择项
     * @param id 巡检点主键id
     */
    void deleteCheckItems(Integer id);

    /**
     * 假删除巡检点
     * @param id 巡检点主键id
     * @return 影响行数
     */
    int falseDelete(int id);
}

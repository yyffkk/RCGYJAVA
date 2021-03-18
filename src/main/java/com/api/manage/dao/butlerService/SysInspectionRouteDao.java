package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchInspectionPoint;
import com.api.model.butlerService.SysInspectionPointRoute;
import com.api.model.butlerService.SysInspectionRoute;
import com.api.vo.butlerService.VoFBIInspectionRoute;
import com.api.vo.butlerService.VoFBIInspectionRoutePoint;
import com.api.vo.butlerService.VoInspectionRoute;

import java.util.List;

public interface SysInspectionRouteDao {
    /**
     * 查询所有的巡检路线信息（包含条件搜索）
     * @param searchInspectionPoint 搜索条件
     * @return 巡检路线信息集合
     */
    List<VoInspectionRoute> list(SearchInspectionPoint searchInspectionPoint);

    /**
     * 添加巡检路线
     * @param sysInspectionRoute 巡检路线model
     * @return 影响行数
     */
    int insert(SysInspectionRoute sysInspectionRoute);

    /**
     * 添加巡检路线-点关联
     * @param pointRoute 巡检点-路线 关联表
     * @return 影响行数
     */
    int insertPointRoute(SysInspectionPointRoute pointRoute);

    /**
     * 根据巡检路线主键id查询巡检路线信息
     * @param id 巡检路线主键id
     * @return 巡检路线信息
     */
    VoFBIInspectionRoute findById(Integer id);

    /**
     * 根据巡检路线主键id查询包含的巡检点信息
     * @param id 巡检路线主键id
     * @return 包含的巡检点信息集合
     */
    List<VoFBIInspectionRoutePoint> findByIdRoutePoint(Integer id);

    /**
     * 修改巡检路线信息
     * @param sysInspectionRoute 巡检路线model
     * @return 影响行数
     */
    int update(SysInspectionRoute sysInspectionRoute);

    /**
     * 删除巡检路线包含的巡检点信息
     * @param id 巡检路线主键id
     */
    void deleteRoutePoint(Integer id);
}

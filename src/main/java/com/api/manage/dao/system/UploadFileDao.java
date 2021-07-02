package com.api.manage.dao.system;

import com.api.model.basicArchives.CpmBuilding;
import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.operationManagement.SysGreenArea;
import com.api.model.operationManagement.SysKeyManagement;
import com.api.model.operationManagement.SysServiceBrowsing;

public interface UploadFileDao {
    /**
     * 查询是否存在该单元导入编号
     * @param buildingUnitId 单元导入编号
     * @return 楼宇单元信息
     */
    CpmBuildingUnit findByUnitId(Integer buildingUnitId);

    /**
     * 添加房产信息
     * @param cpmBuildingUnitEstate 楼宇单元房产信息
     * @return 影响行数
     */
    int insertEstate(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    /**
     * 添加楼栋信息
     * @param cpmBuilding 楼宇管理
     * @return 影响行数
     */
    int insertBuilding(CpmBuilding cpmBuilding);

    /**
     * 添加服务浏览信息
     * @param sysServiceBrowsing 服务浏览model信息
     * @return 影响行数
     */
    int insertServiceBrowsing(SysServiceBrowsing sysServiceBrowsing);

    /**
     * 添加钥匙信息
     * @param sysKeyManagement 钥匙管理model信息
     * @return 影响行数
     */
    int insertKey(SysKeyManagement sysKeyManagement);

    /**
     * 添加绿化区域信息
     * @param sysGreenArea 绿化区域model信息
     * @return 影响行数
     */
    int insertGreenArea(SysGreenArea sysGreenArea);

}

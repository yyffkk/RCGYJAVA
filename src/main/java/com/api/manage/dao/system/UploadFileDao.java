package com.api.manage.dao.system;

import com.api.model.basicArchives.CpmBuildingUnit;
import com.api.model.basicArchives.CpmBuildingUnitEstate;
import com.api.model.operationManagement.SysServiceBrowsing;

public interface UploadFileDao {
    /**
     * 查询是否存在该单元导入编号
     * @param buildingUnitId 单元导入编号
     * @return 楼宇单元信息
     */
    CpmBuildingUnit findByUnitId(Integer buildingUnitId);

    /**
     * 添加楼栋信息
     * @param cpmBuildingUnitEstate 楼宇单元房产信息
     * @return 影响行数
     */
    int insertEstate(CpmBuildingUnitEstate cpmBuildingUnitEstate);

    /**
     * 添加服务浏览信息
     * @param sysServiceBrowsing 服务浏览model信息
     * @return 影响行数
     */
    int insertServiceBrowsing(SysServiceBrowsing sysServiceBrowsing);
}

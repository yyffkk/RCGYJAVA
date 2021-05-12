package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchPackageCollection;
import com.api.model.operationManagement.SysPackageCollection;
import com.api.vo.operationManagement.VoFBIPackageCollection;
import com.api.vo.operationManagement.VoPackageCollection;

import java.util.List;

public interface SysPackageCollectionDao {
    /**
     * 查询所有的包裹代收信息（包含条件搜索）
     * @param searchPackageCollection 包裹代收搜索条件
     * @return 包裹代收信息
     */
    List<VoPackageCollection> list(SearchPackageCollection searchPackageCollection);

    /**
     * 添加包裹代收信息
     * @param sysPackageCollection 包裹代收model信息
     * @return 影响行数
     */
    int insert(SysPackageCollection sysPackageCollection);

    /**
     *  根据包裹代收主键id 查询包裹代收信息
     * @param id 包裹代收主键id
     * @return 包裹代收信息
     */
    VoFBIPackageCollection findById(Integer id);

    /**
     * 修改包裹代收信息
     * @param sysPackageCollection 包裹代收model信息
     * @return map
     */
    int update(SysPackageCollection sysPackageCollection);

    /**
     * 根据包裹代收主键id 删除包裹代收信息
     * @param id 包裹代收主键id
     * @return 影响行数
     */
    int delete(int id);
}

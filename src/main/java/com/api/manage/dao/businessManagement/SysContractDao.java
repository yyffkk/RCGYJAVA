package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchContract;
import com.api.model.businessManagement.SysContract;
import com.api.vo.businessManagement.VoContract;

import java.util.List;

public interface SysContractDao {
    /**
     * 查询所有的合同管理信息
     * @param searchContract 合同管理搜索条件
     * @return 合同管理信息
     */
    List<VoContract> list(SearchContract searchContract);

    /**
     * 添加合同信息
     * @param sysContract 合同管理model
     * @return 影响行数
     */
    int insert(SysContract sysContract);

    /**
     * 根据合同管理主键id查询合同信息
     * @param id 合同管理主键id
     * @return 合同信息
     */
    VoContract findById(int id);

    /**
     * 根据合同管理主键id删除合同信息
     * @param id 合同管理主键id
     * @return 影响行数
     */
    int delete(int id);
}

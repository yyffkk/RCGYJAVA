package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchLeaseContract;
import com.api.model.butlerService.SysLeaseContract;
import com.api.vo.butlerService.VoLeaseContract;

import java.util.List;

public interface LeaseContractDao {
    /**
     * 查询所有的租赁合同信息
     * @param searchLeaseContract 租赁合同管理 搜索条件
     * @return 租赁合同信息
     */
    List<VoLeaseContract> list(SearchLeaseContract searchLeaseContract);

    /**
     * 添加租赁合同信息
     * @param sysLeaseContract 租赁合同model
     * @return 影响行数
     */
    int insert(SysLeaseContract sysLeaseContract);

    /**
     * 根据租赁合同主键id查询租赁合同信息
     * @param id 租赁合同主键id
     * @return 租赁合同信息
     */
    VoLeaseContract findById(Integer id);

    /**
     * 根据租赁合同主键id修改租赁合同启用状态
     * @param sysLeaseContract 租赁合同model
     * @return 影响行数
     */
    int updateStatus(SysLeaseContract sysLeaseContract);

    /**
     * 停用所有模版
     * @return 影响行数
     */
    int disEnableAll();

    /**
     * 根据租赁合同主键id删除租赁合同模版
     * @param id 租赁合同主键id
     * @return 影响行数
     */
    int delete(int id);
}

package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchLease;
import com.api.model.butlerService.SysLease;
import com.api.vo.butlerService.VoFBILease;
import com.api.vo.butlerService.VoLease;

import java.util.List;

public interface LeaseDao {
    /**
     * 查询所有的租赁管理信息
     * @param searchLease 租赁管理 搜索条件
     * @return 租赁管理信息
     */
    List<VoLease> list(SearchLease searchLease);

    /**
     * 添加租赁信息
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int insert(SysLease sysLease);

    /**
     * 根据租赁管理主键id查询租赁信息
     * @param id 租赁管理主键id
     * @return 租赁信息
     */
    VoFBILease findById(Integer id);

    /**
     * 根据租赁管理主键id修改租赁信息
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int update(SysLease sysLease);

    /**
     * 根据租赁管理主键id删除租赁信息
     * @param id 租赁管理主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 审核签署合同内容
     * @param sysLease 租赁管理model
     * @return 影响行数
     */
    int reviewer(SysLease sysLease);
}

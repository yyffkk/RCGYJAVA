package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchSecurityManagement;
import com.api.model.butlerService.SecurityManagement;
import com.api.vo.basicArchives.VoFindAll;
import com.api.vo.butlerService.VoFBISecurityManagement;
import com.api.vo.butlerService.VoSecurityManagement;

import java.util.List;

/**
 * 安全管理
 */
public interface SysSecurityManagementDao {
    /**
     * 查询所有的安全管理信息
     * @param searchSecurityManagement 安全管理搜索条件
     * @return 安全管理 Vo list 回显
     */
    List<VoSecurityManagement> list(SearchSecurityManagement searchSecurityManagement);

    /**
     * 添加安全管理信息
     * @param securityManagement 安全管理信息
     * @return 影响行数
     */
    int insert(SecurityManagement securityManagement);

    /**
     * 查询所有的登记人姓名
     * @return 所有的登记人姓名和id
     */
    List<VoFindAll> findAllCreateName();

    /**
     * 根据安全管理主键id查询安全管理信息
     * @param id 安全管理主键id
     * @return 安全管理信息
     */
    VoFBISecurityManagement findById(Integer id);

    /**
     * 修改安全管理信息
     * @param securityManagement 安全管理信息
     * @return 影响行数
     */
    int update(SecurityManagement securityManagement);

    /**
     * 删除安全管理信息
     * @param id 安全管理信息主键id数组
     * @return 影响行数
     */
    int delete(int id);
}

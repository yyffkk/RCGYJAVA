package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchSecurityManagement;
import com.api.model.butlerService.SecurityManagement;
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
}

package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.SearchServiceBrowsing;
import com.api.model.operationManagement.SysServiceBrowsing;
import com.api.vo.operationManagement.VoFBIServiceBrowsing;
import com.api.vo.operationManagement.VoServiceBrowsing;

import java.util.List;

public interface SysServiceBrowsingDao {
    /**
     * 查询所有的服务浏览信息（包含条件搜索）
     * @param searchServiceBrowsing 服务浏览搜索条件
     * @return 服务浏览信息
     */
    List<VoServiceBrowsing> list(SearchServiceBrowsing searchServiceBrowsing);

    /**
     * 添加服务浏览信息
     * @param sysServiceBrowsing 服务浏览model信息
     * @return 影响行数
     */
    int insert(SysServiceBrowsing sysServiceBrowsing);

    /**
     * 根据服务浏览主键id查询服务浏览信息
     * @param id 服务浏览主键id
     * @return 服务浏览信息
     */
    VoFBIServiceBrowsing findById(Integer id);

    /**
     * 修改服务浏览信息
     * @param sysServiceBrowsing 服务浏览model信息
     * @return 影响行数
     */
    int update(SysServiceBrowsing sysServiceBrowsing);

    /**
     * 根据服务浏览主键id删除服务浏览信息
     * @param id 服务浏览主键id
     * @return 影响行数
     */
    int delete(int id);
}

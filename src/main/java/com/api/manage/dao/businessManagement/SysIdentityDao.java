package com.api.manage.dao.businessManagement;

import com.api.model.system.SysIdentity;

import java.util.List;

public interface SysIdentityDao {
    /**
     * 查询所有的身份（职业）信息
     * @return 所有的身份（职业）信息
     */
    List<SysIdentity> listAll();

    /**
     * 添加身份（职业,岗位信息）
     * @param sysIdentity 身份（职业,岗位）
     * @return 影响行数
     */
    int insert(SysIdentity sysIdentity);

    /**
     * 根据身份主键id查询身份信息
     * @param id 身份主键id
     * @return 身份信息
     */
    SysIdentity findById(Integer id);

    /**
     * 修改身份信息
     * @param sysIdentity 身份信息
     * @return 影响行数
     */
    int update(SysIdentity sysIdentity);

    /**
     * 根据身份主键id查询是否有角色拥有该身份
     * @param positionId 身份主键id
     * @return 拥有人数
     */
    int findUserByPositionId(int positionId);

    /**
     * 根据身份主键id删除身份信息
     * @param id 身份主键id
     * @return 身份信息
     */
    int delete(int id);
}

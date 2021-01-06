package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchUser;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoUser;

import java.util.List;

public interface SysUserDao {
    /**
     * 查询所有的人员管理 包含条件搜索
     * @param searchUser 搜索条件
     * @return 人员管理信息集合
     */
    List<VoUser> list(SearchUser searchUser);

    /**
     * 添加员工信息
     * @param sysUser 员工信息
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 根据手机号查询信息
     * @param tel 手机号
     * @return 用户信息
     */
    SysUser findByTel(String tel);

    /**
     * 根据身份证号查询信息
     * @param idCard 身份证号
     * @return 用户信息
     */
    SysUser findByIdCard(String idCard);
}

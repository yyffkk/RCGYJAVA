package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SearchUser;
import com.api.model.businessManagement.SysUser;
import com.api.vo.businessManagement.VoFindByIdUser;
import com.api.vo.businessManagement.VoUser;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据主键id查询人员信息
     * @param id 主键id
     * @return 人员信息
     */
    VoFindByIdUser findById(Integer id);

    /**
     * 修改员工信息
     * @param sysUser 新员工信息
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 假删除员工信息
     * @param id 员工主键id
     * @return 影响行数
     */
    int falseDelete(Integer id);

    /**
     * 禁止登录
     * @param id 员工主键id
     * @return 影响行数
     */
    int disableLogins(Integer id);

    /**
     * 允许登录
     * @param id 员工主键id
     * @return 影响行数
     */
    int allowLogins(Integer id);

    /**
     * 停用
     * @param id 员工主键id
     * @return 影响行数
     */
    int stop(Integer id);

    /**
     * 恢复
     * @param id 员工主键id
     * @return 影响行数
     */
    int recovery(Integer id);

    /**
     * 重置密码
     * @param sysUser 人员信息
     * @return 影响行数
     */
    int resetPWD(SysUser sysUser);
}

package com.api.manage.dao.businessManagement;

import com.api.model.businessManagement.SysOrganization;
import com.api.vo.app.IdAndName;
import com.api.vo.businessManagement.VoFindByIdOrganization;
import com.api.vo.businessManagement.VoOrganization;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 组织Dao接口
 */
@Component
public interface SysOrganizationDao {
    /**
     * 根据组织ID查找组织信息
     * @param id 组织ID
     * @return 组织架构Vo findById 回显
     */
    VoFindByIdOrganization findById(Integer id);

    /**
     * 查询所有的组织架构信息
     * @param parentId 上级ID
     * @return 组织架构Vo 回显 list
     */
    List<VoOrganization> list(Integer parentId);

    /**
     * 查询各组织，各部门人数
     * @param id 组织或部门id
     * @return 人数
     */
    int countNum(Integer id);

    /**
     * 添加部门
     * @param sysOrganization 组织信息
     * @return 影响行数
     */
    int insert(SysOrganization sysOrganization);

    /**
     * 修改部门
     * @param sysOrganization 组织信息
     * @return 影响行数
     */
    int update(SysOrganization sysOrganization);

    /**
     * 删除部门
     * @param id 组织主键id
     * @return 影响行数
     */
    int delete(Integer id);

    /**
     * 停用部门
     * @param id 组织主键id
     * @return 影响行数
     */
    int stop(Integer id);

    /**
     * 恢复部门
     * @param id 组织主键id
     * @return 影响行数
     */
    int recovery(Integer id);

    /**
     * 根据组织主键id 查询上级id
     * @param organizationId 组织主键id
     * @return 上级id
     */
    int findParentIdById(Integer organizationId);

    /**
     * 根据上级id查询组织信息集合的 id和name
     * @param parentId 组织上级id
     * @return id and name
     */
    List<IdAndName> findListByParentId(Integer parentId);

    /**
     * 查询所有的部门id 和 name（类别为部门、工作组、单位、维修公司的）
     * @return 部门id 和 name
     */
    List<IdAndName> findAllDepartment();

}

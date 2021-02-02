package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;

public interface ButlerRepairDao {
    /**
     * 根据角色id查询权限id集合
     * @param roleId 角色id
     * @return 权限id集合
     */
    List<Integer> findJIdsByRoleId(Integer roleId);

    /**
     * 派单人：查询所有的报事报修信息(包含条件搜索)
     * @param butlerRepairSearch 搜索条件
     * @return 报事报修信息集合
     */
    List<ButlerRepairVo> list1(ButlerRepairSearch butlerRepairSearch);

    /**
     * 接单人：查询所有的报事报修信息(包含条件搜索)
     * @param butlerRepairSearch 搜索条件
     * @return 报事报修信息集合
     */
    List<ButlerRepairVo> list2(ButlerRepairSearch butlerRepairSearch);

    /**
     * 其他角色：查询所有的报事报修信息(包含条件搜索)
     * @param butlerRepairSearch 搜索条件
     * @return 报事报修信息集合
     */
    List<ButlerRepairVo> list3(ButlerRepairSearch butlerRepairSearch);
}

package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerRepairSearch;
import com.api.model.butlerApp.ButlerUserIdAndRepairId;
import com.api.vo.butlerApp.ButlerDispatchTypeVo;
import com.api.vo.butlerApp.ButlerProcessRecordVo;
import com.api.vo.butlerApp.ButlerRepairFindByIdVo;
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

    /**
     * 根据用户主键id 和 报事报修主键id 查询报修详情
     * @param butlerUserIdAndRepairId 用户主键id 与 报事报修主键id
     * @return 报修详情Vo findById 回显
     */
    ButlerRepairFindByIdVo findById(ButlerUserIdAndRepairId butlerUserIdAndRepairId);

    /**
     * 根据用户主键id 和 报事报修主键id 查询工单类型
     * @param butlerUserIdAndRepairId 用户主键id 和 报事报修主键id
     * @return 管家app 工单类型 Vo findById 回显
     */
    ButlerDispatchTypeVo findDispatchTypeById(ButlerUserIdAndRepairId butlerUserIdAndRepairId);

    /**
     * 根据报修id查询报修进程
     * @param repairId 报修id
     * @return 报修进程
     */
    List<ButlerProcessRecordVo> findProcessRecord(Integer repairId);

    /**
     * 根据用户主键id 和 报事报修主键id 查询报修详情
     * @param butlerUserIdAndRepairId 用户主键id 和 报事报修主键id
     * @return 报修详情
     */
    ButlerRepairFindByIdVo findById2(ButlerUserIdAndRepairId butlerUserIdAndRepairId);

    /**
     * 根据用户主键id 和 报事报修主键id 查询工单类型
     * @param butlerUserIdAndRepairId 用户主键id 和 报事报修主键id
     * @return 工单类型
     */
    ButlerDispatchTypeVo findDispatchTypeById2(ButlerUserIdAndRepairId butlerUserIdAndRepairId);
}

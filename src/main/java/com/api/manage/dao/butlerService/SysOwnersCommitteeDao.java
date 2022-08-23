package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchOwnersCommittee;
import com.api.model.butlerService.SysOwnersCommittee;
import com.api.model.butlerService.SysSetting;
import com.api.vo.butlerService.VoFindByIdOwnersCommittee;
import com.api.vo.butlerService.VoOwnersCommittee;

import java.util.List;

public interface SysOwnersCommitteeDao {
    /**
     * 查询所有的业委会信息 （包含条件搜索）
     * @param searchOwnersCommittee 搜索条件
     * @return 业委会信息集合
     */
    List<VoOwnersCommittee> list(SearchOwnersCommittee searchOwnersCommittee);

    /**
     * 添加业委会信息
     * @param sysOwnersCommittee 业委会信息
     * @return 影响行数
     */
    int insert(SysOwnersCommittee sysOwnersCommittee);

    /**
     * 根据业委会主键id查询业委会信息
     * @param id 业委会主键id
     * @return 业委会信息
     */
    VoFindByIdOwnersCommittee findById(Integer id);

    /**
     * 更新业委会信息
     * @param sysOwnersCommittee 新业委会信息
     * @return 影响行数
     */
    int update(SysOwnersCommittee sysOwnersCommittee);

    /**
     * 根据业委会主键id删除业委会信息
     * @param id 业委会主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据功能标识查询系统设置
     * @param action 功能表识
     * @return 系统设置
     */
    SysSetting findSettingByAction(String action);

    /**
     * 根据id修改系统设置
     * @param owners 系统设置表
     * @return 影响行数
     */
    int updateSettingById(SysSetting owners);

    /**
     * 添加系统设置
     * @param sysSetting 系统设置表
     * @return 影响行数
     */
    int insertSetting(SysSetting sysSetting);

    String findOwnersTel(String owners);
}

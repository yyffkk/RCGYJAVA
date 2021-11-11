package com.api.manage.service.operationManagement;

import com.api.model.operationManagement.SurroundingEnterprisesInsert;
import com.api.model.operationManagement.SurroundingEnterprisesSearch;
import com.api.vo.operationManagement.SysSurroundingEnterprisesVo;

import java.util.List;
import java.util.Map;

public interface SysSurroundingEnterprisesService {
    /**
     * 查询所有的周边企业信息
     * @param surroundingEnterprisesSearch 周边企业 搜索条件
     * @return 所有的周边企业信息
     */
    List<SysSurroundingEnterprisesVo> list(SurroundingEnterprisesSearch surroundingEnterprisesSearch);

    /**
     * 新增周边企业
     * @param surroundingEnterprisesInsert 周边企业新增model
     * @return map
     */
    Map<String, Object> insert(SurroundingEnterprisesInsert surroundingEnterprisesInsert);

    /**
     * 根据周边企业主键id查询周边企业
     * @param surroundingEnterprisesId 周边企业主键id
     * @return map
     */
    Map<String, Object> findById(Integer surroundingEnterprisesId);

    /**
     * 修改周边企业
     * @param surroundingEnterprisesInsert 周边企业新增model
     * @return map
     */
    Map<String, Object> update(SurroundingEnterprisesInsert surroundingEnterprisesInsert);

    /**
     * 删除周边企业
     * @param ids 周边企业主键id数组
     * @return map
     */
    Map<String, Object> delete(int[] ids);

    /**
     * 发布消息
     * @param surroundingEnterprisesId 周边企业主键id
     * @return map
     */
    Map<String, Object> release(Integer surroundingEnterprisesId);
}

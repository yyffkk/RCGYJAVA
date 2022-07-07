package com.api.manage.dao.chargeManagement;

import com.api.model.chargeManagement.SearchPaper;
import com.api.model.chargeManagement.SysPaper;
import com.api.vo.chargeManagement.SysPaperVo;

import java.util.List;

public interface SysPaperDao {
    /**
     * 查询所有的票据信息（包含条件搜索）
     * @param searchPaper 搜索条件
     * @return 票据信息
     */
    List<SysPaperVo> list(SearchPaper searchPaper);

    /**
     * 添加企业票据信息
     * @param sysPaper 票据管理mode
     * @return 影响行数
     */
    int insertEnterprise(SysPaper sysPaper);

    /**
     * 添加个人票据信息
     * @param sysPaper 票据管理mode
     * @return 影响行数
     */
    int insertPersonal(SysPaper sysPaper);

    /**
     * 领用票据
     * @param sysPaper 票据管理mode
     * @return 影响行数
     */
    int recipients(SysPaper sysPaper);

    /**
     * 根据票据主键id删除票据信息
     * @param id 票据主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 根据票据主键id查询票据信息
     * @param id 票据主键id
     * @return 票据信息
     */
    SysPaperVo findById(int id);


}

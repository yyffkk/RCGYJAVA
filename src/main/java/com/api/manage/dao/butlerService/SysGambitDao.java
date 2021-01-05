package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchGambit;
import com.api.model.butlerService.SysGambit;
import com.api.vo.butlerService.VoFindByIdGambit;
import com.api.vo.butlerService.VoGambit;

import java.util.List;

public interface SysGambitDao {
    /**
     * 查询所有的话题信息 （包含条件搜索）
     * @param searchGambit 搜索条件
     * @return 话题信息集合
     */
    List<VoGambit> list(SearchGambit searchGambit);

    /**
     * 查询参与人数
     * @param id 话题主键ID
     * @return 参与人数
     */
    int countGambitNum(Integer id);

    /**
     * 添加话题信息(物业后台添加)
     * @param sysGambit 话题信息
     * @return 影响行数
     */
    int insert(SysGambit sysGambit);

    /**
     * 根据话题主键id查询话题详情
     * @param id 话题主键id
     * @return 话题详情
     */
    VoFindByIdGambit findById(Integer id);

    /**
     * 修改话题信息(物业后台修改)
     * @param sysGambit 新话题信息
     * @return 修改行数
     */
    int update(SysGambit sysGambit);

    /**
     * 删除话题信息（假删除）
     * @param id 话题主键id
     * @return 影响行数
     */
    int falseDelete(int id);

    /**
     * 启用社区话题
     * @param id 话题主键id
     * @return 影响行数
     */
    int enableGambit(Integer id);

    /**
     * 禁用社区话题
     * @param id 话题主键id
     * @return 影响行数
     */
    int disableGambit(Integer id);
}

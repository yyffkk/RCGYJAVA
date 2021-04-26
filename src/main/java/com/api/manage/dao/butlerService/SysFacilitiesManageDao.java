package com.api.manage.dao.butlerService;

import com.api.model.butlerService.FacilitiesManage;
import com.api.model.butlerService.SearchFacilitiesManage;
import com.api.vo.butlerService.VoFacilitiesManage;
import com.api.vo.butlerService.VoFacilitiesManageDetail;
import com.api.vo.butlerService.VoFacilitiesManageSituation;

import java.util.List;

public interface SysFacilitiesManageDao {
    /**
     * 查询所有的设施信息（包含搜索条件）
     * @param searchFacilitiesManage 设施分类搜索条件
     * @return 设施信息集合
     */
    List<VoFacilitiesManage> list(SearchFacilitiesManage searchFacilitiesManage);

    /**
     * 添加设施信息
     * @param facilitiesManage 设施管理信息model
     * @return 影响行数
     */
    int insert(FacilitiesManage facilitiesManage);

    /**
     * 修改设施信息
     * @param facilitiesManage 设施管理信息model
     * @return 影响行数
     */
    int update(FacilitiesManage facilitiesManage);

    /**
     * 根据设施主键id查询设施详情
     * @param id 设施主键ID
     * @return 设施详情
     */
    VoFacilitiesManageDetail findDetailById(Integer id);

    /**
     * 根据设施主键id查询设施情况
     * @param id 设施主键id
     * @return 设施情况集合
     */
    List<VoFacilitiesManageSituation> findSituationById(Integer id);

    /**
     * 根据设施主键id假删除设施信息
     * @param id 设施主键id
     * @return 影响行数
     */
    int delete(int id);

    /**
     * 开启设施
     * @param id 设施主键id
     * @return 影响行数
     */
    int isEnable(Integer id);

    /**
     * 根据设施主键ID查询设施状态
     * @param id 设施主键ID
     * @return 设施状态
     */
    int findStatusById(Integer id);

    /**
     * 根据设施分类主键id 累加 设施分类数量
     * @param facilitiesCategoryId  设施分类主键id
     * @return 影响行数
     */
    int incCategory(Integer facilitiesCategoryId);

    /**
     * 根据设施分类主键id 累减 设施分类数量
     * @param facilitiesCategoryId  设施分类主键id
     * @return 影响行数
     */
    int decCategoryNum(Integer facilitiesCategoryId);
}

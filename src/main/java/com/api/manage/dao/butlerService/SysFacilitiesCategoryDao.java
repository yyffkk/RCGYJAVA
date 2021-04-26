package com.api.manage.dao.butlerService;

import com.api.model.butlerService.FacilitiesCategory;
import com.api.model.butlerService.SearchFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesCategory;
import com.api.vo.butlerService.VoFacilitiesCategoryDetail;

import java.util.List;

public interface SysFacilitiesCategoryDao {
    /**
     * 查询所有的设施分类（包含搜索条件）
     * @param facilitiesCategory 设施分类搜索条件
     * @return 设施分类信息集合
     */
    List<VoFacilitiesCategory> list(SearchFacilitiesCategory facilitiesCategory);

    /**
     * 添加设施分类信息
     * @param facilitiesCategory 设施分类管理model
     * @return 影响行数
     */
    int insert(FacilitiesCategory facilitiesCategory);

    /**
     * 根据设施分类主键id查询设施分类信息
     * @param id 设施分类主键id
     * @return 设施分类信息
     */
    VoFacilitiesCategoryDetail findDetailById(Integer id);

    /**
     * 修改设施分类信息
     * @param facilitiesCategory 设施分类管理model
     * @return 影响行数
     */
    int update(FacilitiesCategory facilitiesCategory);

    /**
     * 根据设施分类主键id删除设施分类信息
     * @param id 设施分类主键id
     * @return 影响行数
     */
    int delete(int id);
}

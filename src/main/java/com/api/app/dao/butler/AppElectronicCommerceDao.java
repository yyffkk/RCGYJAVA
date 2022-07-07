package com.api.app.dao.butler;

import com.api.model.app.AppElectronicCommerceVo;
import com.api.model.app.AppElectronicCommerceVoFBI;
import com.api.model.app.SearchAppElectronicCommerce;
import com.api.vo.app.IdAndName;

import java.util.List;

public interface AppElectronicCommerceDao {
    /**
     * 查询所有的电子商务分类(【全部】是默认显示的值)
     * @return 电子商务分类
     */
    List<IdAndName> findAllCategory();

    /**
     * 根据电子商务分类主键id查询电子商务信息
     * @param searchAppElectronicCommerce app电子商务搜索条件
     * @return 电子商务信息
     */
    List<AppElectronicCommerceVo> electronicCommerceList(SearchAppElectronicCommerce searchAppElectronicCommerce);

    /**
     * 根据电子商务主键id 查询电子商务信息详情
     * @param electronicCommerceId 电子商务主键id
     * @return 电子商务信息详情
     */
    AppElectronicCommerceVoFBI findElectronicCommerceById(Integer electronicCommerceId);
}

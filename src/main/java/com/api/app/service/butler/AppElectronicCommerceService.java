package com.api.app.service.butler;

import com.api.model.app.AppElectronicCommerceVo;
import com.api.model.app.SearchAppElectronicCommerce;
import com.api.vo.app.AppNewsVo;

import java.util.List;
import java.util.Map;

public interface AppElectronicCommerceService {
    Map<String, Object> categoryList();

    List<AppElectronicCommerceVo> electronicCommerceList(SearchAppElectronicCommerce searchAppElectronicCommerce);

    Map<String, Object> findElectronicCommerceById(Integer electronicCommerceId);
}

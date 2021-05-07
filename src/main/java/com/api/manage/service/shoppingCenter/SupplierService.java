package com.api.manage.service.shoppingCenter;

import com.api.model.shoppingCenter.Supplier;
import com.api.model.shoppingCenter.SupplierSearch;
import com.api.vo.shoppingCenter.SupplierVo;

import java.util.List;
import java.util.Map;

public interface SupplierService {
    List<SupplierVo> list(SupplierSearch supplierSearch);

    Map<String, Object> insert(Supplier supplier);

    Map<String, Object> findById(Integer id);

    Map<String, Object> update(Supplier supplier);

    Map<String, Object> delete(int[] ids);
}

package com.api.app.dao.butler;

import com.api.vo.app.IdAndName;

import java.util.List;

public interface AppElectronicCommerceDao {
    /**
     * 查询所有的电子商务分类(【全部】是默认显示的值)
     * @return 电子商务分类
     */
    List<IdAndName> findAllCategory();
}

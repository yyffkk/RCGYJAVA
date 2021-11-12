package com.api.app.service.butler;

import com.api.vo.app.AppSurroundingEnterprisesVo;

import java.util.List;

public interface AppSurroundingEnterprisesService {
    /**
     * 查询所有的周边企业信息
     * @return map
     */
    List<AppSurroundingEnterprisesVo> list();
}

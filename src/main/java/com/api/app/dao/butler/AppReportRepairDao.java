package com.api.app.dao.butler;

import com.api.vo.app.AppReportRepairVo;

import java.util.List;

public interface AppReportRepairDao {
    /**
     * app查询当前用户的报事报修信息
     * @param id 用户主键id
     * @return app报事报修Vo list
     */
    List<AppReportRepairVo> list(Integer id);
}

package com.api.app.dao.butler;

import com.api.model.app.SearchVisitorAccess;
import com.api.model.butlerService.UserVisitors;
import com.api.vo.app.VisitorAccessFindByIdVo;
import com.api.vo.app.VisitorAccessVo;

import java.util.List;

public interface VisitorAccessDao {
    /**
     * 添加填写的访客信息
     * @param userVisitors 访问管理表信息
     * @return 影响行数
     */
    int insertVisitorInfo(UserVisitors userVisitors);

    /**
     * 根据访客信息通行证认证码 查询访客信息
     * @param accessCode 访客信息通行证认证码
     * @return app访客通行信息Vo  FindById 回显
     */
    VisitorAccessFindByIdVo findVisitorByAC(Long accessCode);

    /**
     * 查询访客通行信息（包含条件搜索）
     * @param searchVisitorAccess 访客通行搜索条件
     * @return 访客通行信息集合
     */
    List<VisitorAccessVo> list(SearchVisitorAccess searchVisitorAccess);
}

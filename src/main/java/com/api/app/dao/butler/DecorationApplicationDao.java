package com.api.app.dao.butler;

import com.api.model.app.SearchAppDecoration;
import com.api.vo.app.AppDecorationAdditionalCostVo;
import com.api.vo.app.AppDecorationCostVo;
import com.api.vo.app.AppDecorationVo;

import java.util.List;

public interface DecorationApplicationDao {
    /**
     * 查询装修列表
     * @param searchAppDecoration app装修管理搜索条件
     * @return app装修管理Vo list 回显集合
     */
    List<AppDecorationVo> list(SearchAppDecoration searchAppDecoration);

    /**
     * 查询装修押金,费用类型为：3.装修押金
     * @return app装修费用信息Vo list 回显
     */
    AppDecorationCostVo findDecorationDeposit();

    /**
     * 查询装修附加费用
     * @param id 装修押金费用主键id
     * @return app装修额外费用Vo list 回显 集合
     */
    List<AppDecorationAdditionalCostVo> findDecorationAdditionalCost(Integer id);

    /**
     * 查询装修须知doc路径
     * @return 装修须知doc路径
     */
    String findDecorationDocUrl();
}

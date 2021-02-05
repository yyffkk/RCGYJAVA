package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.vo.butlerApp.ButlerBorrowVo;

import java.util.List;

public interface ButlerBorrowDao {
    /**
     * 查询所有的借还信息（包含条件搜索）
     * @param butlerBorrowSearch 管家app 借还管理搜索条件
     * @return 借还信息集合
     */
    List<ButlerBorrowVo> list(ButlerBorrowSearch butlerBorrowSearch);
}

package com.api.manage.dao.butlerService;

import com.api.model.butlerService.SearchBorrow;
import com.api.model.butlerService.SysArticleBorrow;
import com.api.vo.butlerService.VoBorrow;

import java.util.List;

public interface BorrowDao {
    /**
     * 查询所有的借还管理信息 （包含条件搜索）
     * @param searchBorrow 搜索条件
     * @return 借还管理信息
     */
    List<VoBorrow> list(SearchBorrow searchBorrow);

    /**
     * 根据借还管理主键id来查询借还信息
     * @param id 借还管理主键id
     * @return 借还信息
     */
    SysArticleBorrow findById(int id);

    /**
     * 查询所有借还管理信息
     * @return 借还管理信息
     */
    List<SysArticleBorrow> findAll();

}

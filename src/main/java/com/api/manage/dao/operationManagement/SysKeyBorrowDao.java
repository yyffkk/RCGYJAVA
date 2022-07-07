package com.api.manage.dao.operationManagement;

import com.api.model.operationManagement.KeyBorrow;
import com.api.model.operationManagement.SearchKeyBorrow;
import com.api.vo.operationManagement.VoKeyBorrow;

import java.util.List;

public interface SysKeyBorrowDao {
    /**
     * 查询所有的钥匙审核信息
     * @param searchKeyBorrow 钥匙审核搜索条件
     * @return 钥匙审核信息
     */
    List<VoKeyBorrow> list(SearchKeyBorrow searchKeyBorrow);

    /**
     * 查询当前已借出的钥匙数量(当状态为2时，视为已借出)
     * @param keyId 钥匙主键id
     * @return 已借出的钥匙数量
     */
    int countLoanableKeyNum(Integer keyId);

    /**
     * 审核
     * @param keyBorrow 钥匙借还/钥匙审核model管理
     * @return 影响行数
     */
    int examine(KeyBorrow keyBorrow);

    /**
     * 根据审核主键id 查询审核状态
     * @param id 审核主键id
     * @return 审核状态
     */
    int findStatusById(Integer id);

    /**
     * 根据钥匙审核主键id查询钥匙审核model管理
     * @param id 钥匙审核主键id
     * @return 钥匙审核model管理
     */
    KeyBorrow findKeyBorrowById(Integer id);
}

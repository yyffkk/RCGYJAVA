package com.api.dao.butlerService;

import com.api.model.butlerService.SearchBorrow;
import com.api.model.butlerService.SysArticleBorrow;
import com.api.model.butlerService.SysMessage;
import com.api.model.butlerService.SysSending;
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
     * 添加提醒 消息列表 并返回主键id
     * @param sysMessage 消息列表信息
     * @return 影响行数
     */
    int insertMessage(SysMessage sysMessage);

    /**
     * 添加消息接收列表
     * @param sysSending 消息接收列表信息
     * @return 影响行数
     */
    int insertSending(SysSending sysSending);

    /**
     * 查询所有借还管理信息
     * @return 借还管理信息
     */
    List<SysArticleBorrow> findAll();

}

package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerKeyBorrow;
import com.api.model.butlerApp.ButlerKeyIdAndBorrowerId;
import com.api.model.butlerApp.ButlerKeySearch;
import com.api.model.butlerApp.ButlerRecordSearch;
import com.api.vo.butlerApp.ButlerKeyVo;
import com.api.vo.butlerApp.ButlerRecordVo;

import java.util.Date;
import java.util.List;

public interface ButlerKeyDao {
    /**
     * 查询所有的钥匙信息
     * @param butlerKeySearch 管家app 钥匙搜索条件
     * @return 钥匙信息
     */
    List<ButlerKeyVo> list(ButlerKeySearch butlerKeySearch);

    /**
     * 判断该用户是否使用中并查询开始时间
     * @param keyIdAndBorrowerId 管家app 钥匙主键id 和 借取人主键id
     * @return 借取时间/开始时间
     */
    Date findCreateDateByKeyIdAndBorrowerId(ButlerKeyIdAndBorrowerId keyIdAndBorrowerId);

    /**
     * 查询所有的未归还钥匙信息
     * @param butlerKeySearch 管家app 钥匙搜索条件
     * @return 未归还钥匙信息
     */
    List<ButlerKeyVo> noReturnList(ButlerKeySearch butlerKeySearch);

    /**
     * 申请钥匙
     * @param butlerKeyBorrow 管家app 钥匙借取model信息
     * @return 影响行数
     */
    int apply(ButlerKeyBorrow butlerKeyBorrow);

    /**
     * 归还钥匙
     * @param butlerKeyBorrow 管家app 钥匙借取model信息
     * @return 影响行数
     */
    int returnKey(ButlerKeyBorrow butlerKeyBorrow);

    /**
     * 查询所有的申请记录（包含条件搜索）
     * @param butlerRecordSearch 管家app 申请记录搜索条件
     * @return 申请记录
     */
    List<ButlerRecordVo> record(ButlerRecordSearch butlerRecordSearch);
}

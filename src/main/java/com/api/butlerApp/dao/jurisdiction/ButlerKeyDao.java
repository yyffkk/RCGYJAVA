package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerKeyIdAndBorrowerId;
import com.api.model.butlerApp.ButlerKeySearch;
import com.api.vo.butlerApp.ButlerKeyVo;

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
     * 判断该用户是否使用中
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
}

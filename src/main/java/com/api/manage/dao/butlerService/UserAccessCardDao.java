package com.api.manage.dao.butlerService;


import com.api.vo.butlerService.VoUserAccessCard;

import java.util.List;

public interface UserAccessCardDao {
    /**
     * 查询装修所占有的门禁卡数量
     * @param id 装修主键id
     * @return 门禁卡数量
     */
    int countCardNum(Integer id);

    /**
     * 显示所有门禁卡信息
     * @param id 装修主键id
     * @return 门禁卡Vo 显示list
     */
    List<VoUserAccessCard> userAccessCardList(Integer id);
}

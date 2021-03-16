package com.api.butlerApp.dao.jurisdiction;

import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;

public interface ButlerBacklogDao {

    /**
     * 查询报事报修 待分配事项
     * @param id 用户主键id
     * @return 管家app 报事报修Vo list 回显
     */
    List<ButlerRepairVo> backlogDispatchList(int id);

    /**
     * 查询报事报修 已分配未接单事项
     * @param id 用户主键id
     * @return 管家app 报事报修Vo list 回显
     */
    List<ButlerRepairVo> backlogReceivingList(int id);

    /**
     * 查询物品出门 待出门事项
     * @return 管家app 物品出户Vo list 回显
     */
    List<ButlerArticleOutVo> backlogReleasedList();


}

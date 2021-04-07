package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerUserIdAndStatus;
import com.api.vo.butlerApp.ButlerArticleOutVo;
import com.api.vo.butlerApp.ButlerRepairVo;

import java.util.List;

public interface ButlerBacklogDao {

    /**
     * 查询报事报修 派单人事项
     * @param butlerUserIdAndStatus 用户主键id 和 事项状态
     * @return 管家app 报事报修Vo list 回显
     */
    List<ButlerRepairVo> backlogDispatchList(ButlerUserIdAndStatus butlerUserIdAndStatus);

    /**
     * 查询报事报修 接单人事项
     * @param butlerUserIdAndStatus 用户主键id 和 事项状态
     * @return 管家app 报事报修Vo list 回显
     */
    List<ButlerRepairVo> backlogReceivingList(ButlerUserIdAndStatus butlerUserIdAndStatus);

    /**
     * 查询物品出门 放行人事项
     * @param backlogStatus 事项状态
     * @return 管家app 物品出户Vo list 回显
     */
    List<ButlerArticleOutVo> backlogReleasedList(Integer backlogStatus);


    /**
     * 查询派单人待处理事项数量
     * @return 派单人待处理事项数量
     */
    int findUnProcessedNum1();

    /**
     * 查询派单人处理中事项数量
     * @return 派单人处理中事项数量
     */
    int findProcessingNum1();

    /**
     * 查询派单人已处理事项数量
     * @return 派单人已处理事项数量
     */
    int findProcessedNum1();

    /**
     * 查询接单人未处理事项
     * @param id 用户主键id
     * @return 接单人未处理事项
     */
    int findUnProcessedNum2(int id);

    /**
     * 查询接单人处理中事项
     * @param id 用户主键id
     * @return 接单人处理中事项
     */
    int findProcessingNum2(int id);

    /**
     * 查询接单人已处理事项
     * @param id 用户主键id
     * @return 接单人已处理事项
     */
    int findProcessedNum2(int id);

    /**
     * 查询放行人未处理事项
     * @return 放行人未处理事项
     */
    int findUnProcessedNum3();


    /**
     * 查询放行人已处理事项
     * @return 放行人已处理事项
     */
    int findProcessedNum3();
}

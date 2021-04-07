package com.api.butlerApp.dao.message;

import com.api.model.butlerApp.ButlerAppCommentMessage;
import com.api.model.butlerApp.ButlerAppSysMessage;
import com.api.vo.butlerApp.ButlerCommentMessageVo;
import com.api.vo.butlerApp.ButlerRepairCommentMesVo;
import com.api.vo.butlerApp.ButlerRepairMessageVo;
import com.api.vo.butlerApp.ButlerSysMessageVo;

import java.util.Date;
import java.util.List;

public interface ButlerAppMessageDao {
    /**
     * 根据用户id 查询系统通知未读数量
     * @param id 用户id
     * @return 系统通知未读数量
     */
    int findSysNoReadNumById(Integer id);

    /**
     * 根据用户id 查询系统通知最新的第一个消息类型
     * @param id 用户id
     * @return 系统通知最新的第一个消息类型
     */
    Integer findFirstTypeById(Integer id);

    /**
     * 根据用户id 查询评论消息未读数量
     * @param id 用户id
     * @return 评论消息未读数量
     */
    int findCommentNoReadNumById(Integer id);

    /**
     * 查询所有的系统通知
     * @param id 用户主键id
     * @return 管家端系统消息Vo 回显
     */
    List<ButlerSysMessageVo> sysMessageList(Integer id);

    /**
     * 查询所有的评论通知
     * @param id 用户主键id
     * @return 管家app 评论消息Vo 回显
     */
    List<ButlerCommentMessageVo> sysCommentMessageList(Integer id);

    /**
     * 添加系统消息信息
     * @param butlerAppCommentMessage 管家app 评价消息model
     * @return 影响行数
     */
    int insert(ButlerAppCommentMessage butlerAppCommentMessage);

    /**
     * 添加系统消息
     * @param butlerAppSysMessage 管家app 系统消息model
     * @return 影响行数
     */
    int insertSysMessage(ButlerAppSysMessage butlerAppSysMessage);

    /**
     * 根据报事报修主键id 查询报事报修信息（异步）
     * @param repairId 报事报修主键id
     * @return 报事报修消息信息
     */
    ButlerRepairMessageVo findRepairByRepairId(Integer repairId);

    /**
     * 根据工单主键id同步查询报事报修评论（同步）
     * @param dispatchId 工单主键id
     * @return 报事报修评论
     */
    ButlerRepairCommentMesVo findCommentByDispatchId(Integer dispatchId);

    /**
     * 根据用户id 查询系统通知最新的第一个发送时间
     * @param id 用户id
     * @return 系统通知最新的第一个发送时间
     */
    Date findFirstSysDateById(Integer id);

    /**
     * 根据用户id 查询评论消息最新的第一个发送时间
     * @param id 用户id
     * @return 评论消息最新的第一个发送时间
     */
    Date findFirstCommentDateById(Integer id);
}

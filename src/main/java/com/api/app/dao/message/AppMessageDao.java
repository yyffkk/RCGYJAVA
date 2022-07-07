package com.api.app.dao.message;

import com.api.model.app.AppCommentMessage;
import com.api.model.app.UserIdAndSysMessageId;
import com.api.vo.app.AppCommentMessageVo;
import com.api.vo.app.AppSysMessageDetail;
import com.api.vo.app.AppSysMessageVo;

import java.util.List;

public interface AppMessageDao {
    /**
     * 根据用户id 查询系统通知未读数量
     * @param id 用户id
     * @return 系统通知未读数量
     */
    int findSysNoReadNumById(Integer id);

    /**
     * 根据用户id 查询系统通知最新的消息标题
     * @param id 用户id
     * @return 系统通知最新的消息标题
     */
    String findNewTitleById(Integer id);

    /**
     * 查询所有的系统通知
     * @param id 用户id
     * @return 系统通知集合
     */
    List<AppSysMessageVo> sysMessageList(Integer id);

    /**
     * 查询所有的评论通知
     * @param id 用户id
     * @return 评论通知集合
     */
    List<AppCommentMessageVo> sysCommentMessageList(Integer id);

    /**
     * 根据消息列表主键id查询系统通知消息详情
     * @param userIdAndSysMessageId 用户主键id 和 消息列表主键id
     * @return 系统通知详情
     */
    AppSysMessageDetail sysMessageDetail(UserIdAndSysMessageId userIdAndSysMessageId);

    /**
     * 阅读消息（未读 -> 已读）
     * @param userIdAndSysMessageId 用户主键id 和 消息列表主键id
     * @return 影响行数
     */
    int readMessage(UserIdAndSysMessageId userIdAndSysMessageId);

    /**
     * 系统通知全部已读
     * @param id 用户id
     * @return 影响行数
     */
    int allReadSys(Integer id);

    /**
     * 评论通知全部已读
     * @param id 用户id
     * @return 影响行数
     */
    int allReadComment(Integer id);

    /**
     * 删除app消息列表
     * @param userIdAndSysMessageId 用户主键id 和 消息列表主键id
     * @return 影响行数
     */
    int falseDelete(UserIdAndSysMessageId userIdAndSysMessageId);

    /**
     * 根据用户id 查询评论通知未读数量
     * @param id 用户id
     * @return 评论通知未读数量
     */
    int findCommentNoReadNumById(Integer id);

    /**
     * 根据用户id 查询评论通知最新的第一个评论消息
     * @param id 用户id
     * @return 评论通知最新的第一个评论消息
     */
    AppCommentMessageVo findCommentNewTitleById(Integer id);

    /**
     * 添加评论通知消息列表
     * @param appCommentMessage 评论通知消息列表
     * @return 影响行数
     */
    int insertCommentMessage(AppCommentMessage appCommentMessage);

    /**
     * 根据主题id，类型，接收人id，点赞人 删除点赞通知信息
     * @param appCommentMessage 评论通知消息列表
     * @return 影响行数
     */
    int deleteCommentMessage(AppCommentMessage appCommentMessage);

}

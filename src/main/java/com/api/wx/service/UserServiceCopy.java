package com.api.wx.service;

import com.api.wx.common.exception.ExceptionMessage;
import com.api.wx.entity.User;
import com.api.wx.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author leone
 * @since 2018-06-03
 **/
@Slf4j
@Service
public class UserServiceCopy {

    @Resource
    private UserMapper userMapper;

    /**
     *
     * @param userId
     * @return
     */
    public User findOne(Long userId) {
        User user = userMapper.findByUserId(userId);
        Assert.notNull(user, ExceptionMessage.USER_NOT_EXIST.getMessage());
        return user;
    }


}

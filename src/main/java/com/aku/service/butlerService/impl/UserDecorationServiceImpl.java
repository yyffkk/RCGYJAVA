package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.UserDecorationDao;
import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.service.butlerService.UserDecorationService;
import com.aku.vo.butlerService.VoUserDecoration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserDecorationServiceImpl implements UserDecorationService {
    private static Map<String,Object> map = null;

    @Resource
    UserDecorationDao userDecorationDao;

    @Override
    public List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration) {
        return userDecorationDao.list(searchUserDecoration);
    }
}

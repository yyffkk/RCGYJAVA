package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysGambitThemeDao;
import com.api.model.butlerService.SearchGambitTheme;
import com.api.service.butlerService.SysGambitThemeService;
import com.api.vo.butlerService.VoGambitTheme;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysGambitThemeServiceImpl implements SysGambitThemeService {
    @Resource
    SysGambitThemeDao sysGambitThemeDao;

    @Override
    public List<VoGambitTheme> list(SearchGambitTheme searchGambitTheme) {
        //查询所有的主题明细信息（包含条件搜索）
        List<VoGambitTheme> voGambitThemeList = sysGambitThemeDao.list(searchGambitTheme);
        //查询点赞人数

        //查询评论人数

        return voGambitThemeList;
    }
}

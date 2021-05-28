package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppUserDecorationNewDao;
import com.api.app.service.butler.AppUserDecorationNewService;
import com.api.model.app.AppUserDecorationNew;
import com.api.model.app.SearchAppUserDecorationNew;
import com.api.vo.butlerApp.ButlerUserDecorationNewVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppUserDecorationNewServiceImpl implements AppUserDecorationNewService {
    private static Map<String,Object> map = null;
    @Resource
    AppUserDecorationNewDao appUserDecorationNewDao;

    @Override
    public List<ButlerUserDecorationNewVo> list(SearchAppUserDecorationNew searchAppUserDecorationNew) {
        return appUserDecorationNewDao.list(searchAppUserDecorationNew);
    }

    @Override
    public Map<String, Object> insert(AppUserDecorationNew appUserDecorationNew, Integer id) {
        map = new HashMap<>();

        appUserDecorationNew.setCreateId(id);
        appUserDecorationNew.setCreateDate(new Date());
        appUserDecorationNew.setStatus(1);//默认1.装修申请中


        int insert = appUserDecorationNewDao.insert(appUserDecorationNew);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }

        return map;
    }
}

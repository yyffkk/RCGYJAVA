package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerVisitorDao;
import com.api.butlerApp.service.butler.ButlerVisitorService;
import com.api.model.butlerApp.ButlerVisitorSearch;
import com.api.vo.butlerApp.ButlerVisitorVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ButlerVisitorServiceImpl implements ButlerVisitorService {
    @Resource
    ButlerVisitorDao butlerVisitorDao;

    @Override
    public List<ButlerVisitorVo> list(ButlerVisitorSearch butlerVisitorSearch) {
        butlerVisitorSearch.setNowDate(new Date());
        List<ButlerVisitorVo> list = butlerVisitorDao.list(butlerVisitorSearch);
        if (list != null && list.size()>0){
            for (ButlerVisitorVo butlerVisitorVo : list) {
                //如果状态为1.未到，并且当前超出有效时间，则改为3.已过期
                if (butlerVisitorVo.getVisitorStatus() == 1 && new Date().getTime()>butlerVisitorVo.getEffectiveTime().getTime()){
                    //3.已过期
                    butlerVisitorVo.setVisitorStatus(3);
                }
            }
        }
        return list;
    }
}

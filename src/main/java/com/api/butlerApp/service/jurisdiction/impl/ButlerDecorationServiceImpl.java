package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerDecorationDao;
import com.api.butlerApp.service.jurisdiction.ButlerDecorationService;
import com.api.model.butlerApp.ButlerDecorationSearch;
import com.api.vo.butlerApp.ButlerDecorationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerDecorationServiceImpl implements ButlerDecorationService {
    @Resource
    ButlerDecorationDao butlerDecorationDao;
    private static Map<String,Object> map = null;


    @Override
    public List<ButlerDecorationVo> list(ButlerDecorationSearch decorationSearch) {
        List<ButlerDecorationVo> butlerDecorationVos = butlerDecorationDao.list(decorationSearch);
        if (butlerDecorationVos != null && butlerDecorationVos.size()>0){
            for (ButlerDecorationVo decorationVo : butlerDecorationVos) {
                if (decorationVo.getTracker() != null){
                    if (decorationVo.getStatus()<5){
                        //2.已指派（待执行）【装修状态为<5】
                        decorationVo.setOperationStatus(2);
                    }else {
                        //3.已完成【装修状态为>=5】
                        decorationVo.setOperationStatus(3);
                    }
                }else {
                    //1.待指派【当检查跟踪人为null且装修状态为>1】查询出来的数据默认装修状态>1，所以不用判断
                    decorationVo.setOperationStatus(1);
                }
            }
        }
        return butlerDecorationVos;
    }

    @Override
    public Map<String, Object> findById(Integer decorationId) {
        map = new HashMap<>();


        return map;
    }
}

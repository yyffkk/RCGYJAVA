package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerDecorationDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerDecorationService;
import com.api.model.butlerApp.ButlerDecorationSearch;
import com.api.vo.butlerApp.ButlerDecorationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ButlerDecorationServiceImpl implements ButlerDecorationService {
    @Resource
    ButlerDecorationDao butlerDecorationDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;


    @Override
    public List<ButlerDecorationVo> list(ButlerDecorationSearch decorationSearch) {
        int type = findJurisdictionByUserId(decorationSearch.getRoleId());
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
                    if (type == 2 || type == 3){
                        //当为跟踪人员和其他 时，不能显示待指派状态 ？？？？？
                    }
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

    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //59.装修派工
                    if (jurisdictionIds.contains(59)){
                        return 1;
                    }else if (jurisdictionIds.contains(60)){
                        return 2;
                    }
                }
            }
        }
        return 3;
    }
}

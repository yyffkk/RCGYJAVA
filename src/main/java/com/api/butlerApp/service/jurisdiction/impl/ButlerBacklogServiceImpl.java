package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerBacklogDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerBacklogService;
import com.api.vo.butlerApp.ButlerBacklogVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ButlerBacklogServiceImpl implements ButlerBacklogService {
    @Resource
    ButlerBacklogDao butlerBacklogDao;
    @Resource
    ButlerRepairDao butlerRepairDao;

    @Override
    public List<ButlerBacklogVo> list(String roleId) {
        //1.派单人,2.接单人,3.放行,4.维修人,5.其他人（管家）
        int type = findJurisdictionByUserId(roleId);
        //创建一个返回对象集合
        ArrayList<ButlerBacklogVo> butlerBacklogVos = new ArrayList<>();
        //创建一个对象集合
        ButlerBacklogVo butlerBacklogVo = new ButlerBacklogVo();


        butlerBacklogVos.add(butlerBacklogVo);
        return butlerBacklogVos;
    }

    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //52.派单人,53.接单人,55.放行,59.维修人
                    if (jurisdictionIds.contains(52)){
                        return 1;
                    }else if (jurisdictionIds.contains(53)){
                        return 2;
                    }else if (jurisdictionIds.contains(55)){
                        return 3;
                    }else if(jurisdictionIds.contains(59)){
                        return 4;
                    }
                }
            }
        }
        return 5;
    }
}

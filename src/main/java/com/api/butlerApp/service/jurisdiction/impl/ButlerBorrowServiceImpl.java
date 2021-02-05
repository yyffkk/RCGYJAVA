package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerBorrowDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerBorrowService;
import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ButlerBorrowServiceImpl implements ButlerBorrowService {
    @Resource
    ButlerBorrowDao butlerBorrowDao;
    @Resource
    ButlerRepairDao butlerRepairDao;
    private static Map<String,Object> map = null;

    @Override
    public ButlerTypeAndBorrowListVo list(ButlerBorrowSearch butlerBorrowSearch) {
        //查询用户所属权限,type:1.可操作角色 3.其他角色
        int type = findJurisdictionByUserId(butlerBorrowSearch.getRoleId());

        List<ButlerBorrowVo> list = butlerBorrowDao.list(butlerBorrowSearch);
        if (list != null && list.size()>0){
            for (ButlerBorrowVo butlerBorrowVo : list) {
                if (butlerBorrowVo.getBorrowStatus() == 1){
                    //1.出借中 当前时间-借出时间
                    long hour = (new Date().getTime() - butlerBorrowVo.getBeginDate().getTime())/(60*60*1000);
                    butlerBorrowVo.setBorrowTime(hour);
                }else if (butlerBorrowVo.getBorrowStatus() == 2 || butlerBorrowVo.getBorrowStatus() == 3){
                    //2.已还 ，3.待检查 归还时间-借出时间
                    long hour = (butlerBorrowVo.getEndDate().getTime() - butlerBorrowVo.getBeginDate().getTime())/(60*60*1000);
                    butlerBorrowVo.setBorrowTime(hour);
                }
                //查询物品照片
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticle", butlerBorrowVo.getArticleId(), "articleImg");
                butlerBorrowVo.setImgUrls(imgByDate);
            }
        }

        ButlerTypeAndBorrowListVo typeAndBorrowListVo = new ButlerTypeAndBorrowListVo();
        //填入当前角色类型
        typeAndBorrowListVo.setType(type);
        //填入所有借还信息集合
        typeAndBorrowListVo.setButlerBorrowVos(list);
        return typeAndBorrowListVo;
    }


    private int findJurisdictionByUserId(String roleIds) {
        String[] split = roleIds.split(",");
        ArrayList<Integer> integers = new ArrayList<>();
        if (split.length >0){
            for (String s : split) {
                int roleId = Integer.parseInt(s);
                //根据角色id查询权限id集合
                List<Integer> jurisdictionIds = butlerRepairDao.findJIdsByRoleId(roleId);
                if (jurisdictionIds != null && jurisdictionIds.size()>0){
                    //57.操作权限
                    if (jurisdictionIds.contains(57)){
                        return 1;
                    }
                }
            }
        }
        return 3;
    }
}

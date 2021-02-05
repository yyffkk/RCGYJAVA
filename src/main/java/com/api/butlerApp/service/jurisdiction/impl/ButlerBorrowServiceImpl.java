package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerBorrowDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerBorrowService;
import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.model.butlerApp.ButlerSubmitCheck;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.ButlerBorrowVo;
import com.api.vo.butlerApp.ButlerCheckItemsVo;
import com.api.vo.butlerApp.ButlerTypeAndBorrowListVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

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
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticleDetail", butlerBorrowVo.getArticleDetailId(), "sysArticleDetailImg");
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

    @Override
    public Map<String, Object> checkItems(Integer articleBorrowId, String roleId) {
        map = new HashMap<>();
        //查询用户所属权限,type:1.可操作角色 3.其他角色
        int type = findJurisdictionByUserId(roleId);
        if (type != 1){
            map.put("message","当前用户没有该权限");
            map.put("status",false);
            return map;
        }
        //根据借还管理主键id查询检查信息
        ButlerCheckItemsVo butlerCheckItemsVo = butlerBorrowDao.checkItems(articleBorrowId);
        if (butlerCheckItemsVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticleDetail", butlerCheckItemsVo.getArticleDetailId(), "sysArticleDetailImg");
            butlerCheckItemsVo.setImgUrls(imgByDate);
        }
        map.put("data",butlerCheckItemsVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> submitCheck(ButlerSubmitCheck butlerSubmitCheck, String roleId) {
        map = new HashMap<>();
        try {
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("当前用户没有该权限");
            }
            //根据借还管理主键id查询借还管理Vo信息
            ButlerBorrowVo butlerBorrowVo = butlerBorrowDao.findStatusByBorrowId(butlerSubmitCheck.getArticleBorrowId());
            if (butlerBorrowVo == null){
                throw new RuntimeException("该借还信息不存在或已被删除");
            }
            if (butlerBorrowVo.getBorrowStatus() != 3){
                throw new RuntimeException("该信息未处于带检查状态");
            }
            //填入物品明细主键id
            butlerSubmitCheck.setArticleDetailId(butlerBorrowVo.getArticleDetailId());

            //根据借还管理主键id修改借还管理物品状态，借取状态和归还时间
            butlerSubmitCheck.setEndDate(new Date());
            //2.已还
            butlerSubmitCheck.setBorrowStatus(2);
            int update = butlerBorrowDao.updateSAEByBorrowId(butlerSubmitCheck);
            if (update <= 0){
                throw new RuntimeException("修改借还信息状态失败");
            }
            //根据物品明细主键id修改物品明细状态
            int update2 = butlerBorrowDao.updateStatusByDetailId(butlerSubmitCheck);
            if (update2 <= 0){
                throw new RuntimeException("修改物品明细信息状态失败");
            }
        } catch (Exception e) {
            //获取抛出的信息
            String message = e.getMessage();
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            map.put("message",message);
            map.put("status",false);
            return map;
        }
        map.put("message","提交成功");
        map.put("status",true);
        return map;
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

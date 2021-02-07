package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerBorrowDao;
import com.api.butlerApp.dao.jurisdiction.ButlerRepairDao;
import com.api.butlerApp.service.jurisdiction.ButlerBorrowService;
import com.api.model.butlerApp.ButlerArticle;
import com.api.model.butlerApp.ButlerArticleDetail;
import com.api.model.butlerApp.ButlerBorrowSearch;
import com.api.model.butlerApp.ButlerSubmitCheck;
import com.api.util.UploadUtil;
import com.api.vo.butlerApp.*;
import com.api.vo.resources.VoResourcesImg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ButlerBorrowServiceImpl implements ButlerBorrowService {
//    private static final Logger log = LoggerFactory.getLogger(ButlerBorrowServiceImpl.class);
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

    @Override
    public List<ButlerArticleVo> articleList() {
        List<ButlerArticleVo> butlerArticleVos = butlerBorrowDao.articleList();
        if (butlerArticleVos != null && butlerArticleVos.size()>0){
            for (ButlerArticleVo butlerArticleVo : butlerArticleVos) {
                //填入照片资源
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticle", butlerArticleVo.getId(), "articleImg");
                butlerArticleVo.setImgUrls(imgByDate);

                //根据物品主键id查询借出数量（查询出的quantity 为 正常物品数量）
                int borrowNum = butlerBorrowDao.findBorrowNumById(butlerArticleVo.getId());
                //填入借取数量
                butlerArticleVo.setBorrowNum(borrowNum);
                //剩余数量， 正常物品数量减去已借出的
                butlerArticleVo.setRemainingNum(butlerArticleVo.getQuantity() - borrowNum);
            }
        }
        return butlerArticleVos;
    }

    @Override
    public Map<String, Object> insertArticle(ButlerArticle butlerArticle, String roleId) {
        map = new HashMap<>();
        try {
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("当前用户没有该权限");
            }

            butlerArticle.setCreateDate(new Date());
            int insert = butlerBorrowDao.insertArticle(butlerArticle);
            if (insert <= 0){
                throw new RuntimeException("新增失败");
            }

        } catch (RuntimeException e) {
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
        map.put("message","新增成功");
        map.put("status",true);
        return map;
    }


    @Override
    public List<ButlerArticleDetailVo> articleDetailList(Integer articleId) {
        List<ButlerArticleDetailVo> detailVos = butlerBorrowDao.articleDetailList(articleId);
        if (detailVos != null && detailVos.size()>0){
            for (ButlerArticleDetailVo detailVo : detailVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticleDetail", detailVo.getId(), "sysArticleDetailImg");
                detailVo.setImgUrls(imgByDate);

                //根据物品明细主键id 查询 出借数量
                int count = butlerBorrowDao.countBorrowByADId(detailVo.getId());
                if (count >0){
                    //2.已借取
                    detailVo.setBorrowStatus(2);
                }else {
                    //1.未出借
                    detailVo.setBorrowStatus(1);
                }
            }
        }
        return detailVos;
    }

    @Override
    public Map<String, Object> findById(Integer articleDetailId) {
        map = new HashMap<>();
        ButlerArticleDetailFBIVo articleDetailFBIVo = butlerBorrowDao.findById(articleDetailId);
        if (articleDetailFBIVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticleDetail", articleDetailFBIVo.getId(), "sysArticleDetailImg");
            articleDetailFBIVo.setImgUrls(imgByDate);

            //根据物品明细主键id 查询 出借数量
            int count = butlerBorrowDao.countBorrowByADId(articleDetailFBIVo.getId());
            if (count >0){
                //2.已借取
                articleDetailFBIVo.setBorrowStatus(2);
            }else {
                //1.未出借
                articleDetailFBIVo.setBorrowStatus(1);
            }
        }
        map.put("data",articleDetailFBIVo);
        map.put("status",true);
        map.put("message","请求成功");
        return map;
    }

    @Override
    public Map<String, Object> updateArticleDetail(ButlerArticleDetail butlerArticleDetail, String roleId) {
        map = new HashMap<>();
        try {
            int type = findJurisdictionByUserId(roleId);
            if (type != 1){
                throw new RuntimeException("当前用户没有该权限");
            }

            butlerArticleDetail.setModifyDate(new Date());
            int update = butlerBorrowDao.updateArticleDetail(butlerArticleDetail);
            if (update <= 0){
                throw new RuntimeException("修改失败");
            }

            //先删除照片资源
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.delete("sysArticleDetail",butlerArticleDetail.getId(),"sysArticleDetailImg");
            //再添加照片资源
            uploadUtil.saveUrlToDB(butlerArticleDetail.getFileUrls(),"sysArticleDetail",butlerArticleDetail.getId(),"sysArticleDetailImg","600",30,20);

        } catch (RuntimeException e) {
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
        map.put("message","修改成功");
        map.put("status",true);
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

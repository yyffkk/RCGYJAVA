package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppArticleBorrowDao;
import com.api.app.service.butler.AppArticleBorrowService;
import com.api.model.app.AppArticleBorrow;
import com.api.model.app.UserIdAndArticleBorrowId;
import com.api.util.UploadUtil;
import com.api.vo.app.AppArticleBorrowDetailVo;
import com.api.vo.app.AppArticleBorrowReturnVo;
import com.api.vo.app.AppArticleBorrowVo;
import com.api.vo.app.AppMyArticleBorrowVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppArticleBorrowServiceImpl implements AppArticleBorrowService {
    @Resource
    AppArticleBorrowDao appArticleBorrowDao;
    private static Map<String,Object> map = null;

    @Override
    public List<AppArticleBorrowVo> list() {
        //查询出的quantity 为 正常物品数量
        List<AppArticleBorrowVo> appArticleBorrowVos = appArticleBorrowDao.list();
        if (appArticleBorrowVos != null && appArticleBorrowVos.size()>0){
            for (AppArticleBorrowVo articleBorrowVo : appArticleBorrowVos) {
                //填入照片资源
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticle", articleBorrowVo.getId(), "articleImg");
                articleBorrowVo.setImgUrls(imgByDate);

                //减去已借出的
                //根据物品主键id查询借出数量
                int num = appArticleBorrowDao.findBorrowNumById(articleBorrowVo.getId());
                articleBorrowVo.setQuantity(articleBorrowVo.getQuantity() - num);
            }
        }
        return appArticleBorrowVos;
    }

    @Override
    public List<AppMyArticleBorrowVo> myList(Integer id) {
        List<AppMyArticleBorrowVo> appMyArticleBorrowVos = appArticleBorrowDao.myList(id);
        if (appMyArticleBorrowVos != null && appMyArticleBorrowVos.size()>0){
            for (AppMyArticleBorrowVo myArticleBorrowVo : appMyArticleBorrowVos) {
                //判断借取状态（-1.出借审核中，0.出借审核失败，1.出借中，2.已还，3.待检查,4.归还审核驳回）
                if (myArticleBorrowVo.getBorrowStatus() == 1 || myArticleBorrowVo.getBorrowStatus() == 4){
                    //1.出借中，4.归还审核驳回
                    //计算出出借时长(现在时间-借出时间)
                    long hour = (new Date().getTime() - myArticleBorrowVo.getBeginDate().getTime())/(60*60*1000);
                    myArticleBorrowVo.setBorrowDate(hour);
                }else if (myArticleBorrowVo.getBorrowStatus() == 2 || myArticleBorrowVo.getBorrowStatus() == 3){
                    //2.已还 3.待检查
                    //计算出出借时长(归还时间-借出时间)
                    long hour = (myArticleBorrowVo.getEndDate().getTime() - myArticleBorrowVo.getBeginDate().getTime())/(60*60*1000);
                    myArticleBorrowVo.setBorrowDate(hour);
                }else {
                    //-1.出借审核中，0.出借审核失败 出借时长默认为0
                    long hour = 0;
                    myArticleBorrowVo.setBorrowDate(hour);
                }
            }
        }
        return appMyArticleBorrowVos;
    }

    @Override
    public Map<String, Object> frmLoss(UserIdAndArticleBorrowId userIdAndArticleBorrowId) {
        map = new HashMap<>();
        int update = appArticleBorrowDao.frmLoss(userIdAndArticleBorrowId);
        if (update > 0){
            map.put("message","您的报损信息已提交");
            map.put("status",true);
        }else {
            map.put("message","您的报损信息提交失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findDetailById(Integer articleId) {
        map = new HashMap<>();
        List<AppArticleBorrowDetailVo> articleBorrowDetailVoList = appArticleBorrowDao.findDetailById(articleId);
        if (articleBorrowDetailVoList != null && articleBorrowDetailVoList.size()>0){
            for (AppArticleBorrowDetailVo appArticleBorrowDetailVo : articleBorrowDetailVoList) {
                //填入物品明细照片信息
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticleDetail", appArticleBorrowDetailVo.getId(), "sysArticleDetailImg");
                appArticleBorrowDetailVo.setImgList(imgByDate);
            }
        }
        map.put("message","请求成功");
        map.put("data",articleBorrowDetailVoList);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> borrow(int[] ids, Integer userId) {
        map = new HashMap<>();
        try {
            //查询出借中或待检查的物品明细主键id数组
            List<Integer> articleIds = appArticleBorrowDao.findBorrowOrCheckArticleId();
            for (int id : ids) {
                if (articleIds.contains(id)){
                    throw new RuntimeException("物品已被出借");
                }
                AppArticleBorrow appArticleBorrow = new AppArticleBorrow();
                appArticleBorrow.setArticleDetailId(id); //填入物品明细id
                appArticleBorrow.setBorrowStatus(0); //填入借取状态,默认0.出借审核中
                appArticleBorrow.setStatus(1); //填入物品状态,默认1.正常
                appArticleBorrow.setBeginDate(new Date()); //填入借出时间
                appArticleBorrow.setCreateId(userId); //填入创建人
                appArticleBorrow.setCreateDate(new Date()); //填入创建时间
                //添加物品借还信息
                int insert = appArticleBorrowDao.borrow(appArticleBorrow);
                if (insert <=0){
                    throw new RuntimeException("借取失败");
                }
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
        map.put("message","借取成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findBorrowByUserId(Integer id) {
        map = new HashMap<>();
        //根据用户主键id查询需要归还物品信息
        List<AppArticleBorrowReturnVo> articleBorrowReturnVoList = appArticleBorrowDao.findBorrowByUserId(id);
        if (articleBorrowReturnVoList != null && articleBorrowReturnVoList.size()>0){
            for (AppArticleBorrowReturnVo appArticleBorrowReturnVo : articleBorrowReturnVoList) {
                //出借时长 当前时间-借出时间
                long hour = (new Date().getTime() - appArticleBorrowReturnVo.getBeginDate().getTime())/(60*60*1000);
                appArticleBorrowReturnVo.setBorrowTime(hour);

                //填入物品明细照片信息
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("sysArticleDetail", appArticleBorrowReturnVo.getId(), "sysArticleDetailImg");
                appArticleBorrowReturnVo.setImgList(imgByDate);
            }
        }
        map.put("message","请求成功");
        map.put("data",articleBorrowReturnVoList);
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> articleReturn(int[] ids, Integer userId) {
        map = new HashMap<>();
        try {
            //查询该用户出借中的物品借还主键id数组
            List<Integer> articleIds = appArticleBorrowDao.findBorrowArticleIdByUserId(userId);
            for (int id : ids) {
                if (articleIds.contains(id)){
                    AppArticleBorrow appArticleBorrow = new AppArticleBorrow();
                    appArticleBorrow.setId(id); //填入借还主键id
                    appArticleBorrow.setBorrowStatus(3); //填入借取状态,默认为3.待检查
                    appArticleBorrow.setEndDate(new Date()); //填入归还时间
                    //根据借还主键id修改物品借还归还状态信息
                    int update = appArticleBorrowDao.articleReturn(appArticleBorrow);
                    if (update <=0){
                        throw new RuntimeException("申请归还失败");
                    }
                }else {
                    throw new RuntimeException("物品信息选择出错");
                }
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
        map.put("message","申请归还成功");
        map.put("status",true);
        return map;
    }
}

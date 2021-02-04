package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppArticleOutDao;
import com.api.app.service.butler.AppArticleOutService;
import com.api.model.app.AppArticleOut;
import com.api.model.app.UserIdAndArticleOutId;
import com.api.util.UploadUtil;
import com.api.vo.app.AppArticleOutQRCodeVo;
import com.api.vo.app.AppArticleOutVo;
import com.api.vo.app.AppMovingCompanyVo;
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
public class AppArticleOutServiceImpl implements AppArticleOutService {
    @Resource
    AppArticleOutDao appArticleOutDao;
    private static Map<String,Object> map = null;

    @Override
    @Transactional
    public Map<String, Object> submit(AppArticleOut appArticleOut) {
        map = new HashMap<>();
        try {
            //根据房产id查询业主信息
//            appArticleOutDao.findOwnerByEstateId(appArticleOut.get);
            //填入状态，初始为1.待出门
            appArticleOut.setStatus(1);
            //填入申请时间
            appArticleOut.setApplicantDate(new Date());
            //填入是否删除（0.删除，1.非删）【用户app端删除】默认为1.非删
            appArticleOut.setUserDelete(1);
            int insert = appArticleOutDao.submit(appArticleOut);
            if (insert <= 0){
                throw new RuntimeException("提交失败");
            }
            //上传照片资源到数据库
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(appArticleOut.getImgUrls(),"userArticleOut",appArticleOut.getId(),"goodsImg","600",30,20);
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
    public Map<String, Object> getMovingCompanyTel() {
        map = new HashMap<>();
        List<AppMovingCompanyVo> appMovingCompanyVoList = appArticleOutDao.getMovingCompanyTel();
        map.put("appMovingCompanyVoList",appMovingCompanyVoList);
        return map;
    }

    @Override
    public List<AppArticleOutVo> list(Integer id) {
        List<AppArticleOutVo> list = appArticleOutDao.list(id);
        if (list != null && list.size()>0){
            for (AppArticleOutVo appArticleOutVo : list) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("userArticleOut", appArticleOutVo.getId(), "goodsImg");
                appArticleOutVo.setImgUrl(imgByDate);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> falseDelete(int[] ids, Integer id) {
        map = new HashMap<>();
        try {
            UserIdAndArticleOutId userIdAndArticleOutId = new UserIdAndArticleOutId();
            //填入用户id
            userIdAndArticleOutId.setUserId(id);
            for (int articleOutId : ids) {
                //填入物品出户主键id
                userIdAndArticleOutId.setArticleOutId(articleOutId);
                //假删除物品出户信息
                int update = appArticleOutDao.falseDelete(userIdAndArticleOutId);
                if (update <=0 ){
                    throw new RuntimeException("删除失败");
                }
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> getQRCode(UserIdAndArticleOutId userIdAndArticleOutId) {
        map = new HashMap<>();
        AppArticleOutQRCodeVo appArticleOutQRCodeVo = appArticleOutDao.findQRCodeByIds(userIdAndArticleOutId);
        if (appArticleOutQRCodeVo == null){
            map.put("message","不存在或已被删除");
            map.put("status",false);
            return map;
        }
        //有效时间 = 预计时间 + 24小时
        appArticleOutQRCodeVo.setEffectiveTime(new Date(appArticleOutQRCodeVo.getEffectiveTime().getTime()+24*60*60*1000));
        map.put("appArticleOutQRCodeVo",appArticleOutQRCodeVo);
        map.put("message","查询成功");
        map.put("status",true);
        return map;
    }
}

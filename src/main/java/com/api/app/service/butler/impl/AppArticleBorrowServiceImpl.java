package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppArticleBorrowDao;
import com.api.app.service.butler.AppArticleBorrowService;
import com.api.model.app.UserIdAndArticleBorrowId;
import com.api.util.UploadUtil;
import com.api.vo.app.AppArticleBorrowDetailVo;
import com.api.vo.app.AppArticleBorrowVo;
import com.api.vo.app.AppMyArticleBorrowVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

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
                //判断借取状态（1.出借中，2.已还）
                if (myArticleBorrowVo.getBorrowStatus() == 1){
                    //1.出借中
                    //计算出出借时长(现在时间-借出时间)
                    long hour = (new Date().getTime() - myArticleBorrowVo.getBeginDate().getTime())/(60*60*1000);
                    myArticleBorrowVo.setBorrowDate(hour);
                }else if (myArticleBorrowVo.getBorrowStatus() == 2){
                    //2.已还
                    //计算出出借时长(归还时间-借出时间)
                    long hour = (myArticleBorrowVo.getEndDate().getTime() - myArticleBorrowVo.getBeginDate().getTime())/(60*60*1000);
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
        map.put("message","请求成功");
        map.put("data",articleBorrowDetailVoList);
        map.put("status",true);
        return map;
    }
}

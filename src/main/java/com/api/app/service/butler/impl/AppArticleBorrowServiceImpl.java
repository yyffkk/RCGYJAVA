package com.api.app.service.butler.impl;

import com.api.app.dao.butler.AppArticleBorrowDao;
import com.api.app.service.butler.AppArticleBorrowService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppArticleBorrowVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppArticleBorrowServiceImpl implements AppArticleBorrowService {
    @Resource
    AppArticleBorrowDao appArticleBorrowDao;

    @Override
    public List<AppArticleBorrowVo> list() {
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
}

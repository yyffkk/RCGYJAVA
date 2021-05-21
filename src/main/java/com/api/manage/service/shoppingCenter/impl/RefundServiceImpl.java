package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.RefundDao;
import com.api.manage.service.shoppingCenter.RefundService;
import com.api.model.shoppingCenter.RefundSearch;
import com.api.util.UploadUtil;
import com.api.vo.resources.VoResourcesImg;
import com.api.vo.shoppingCenter.OrderVo;
import com.api.vo.shoppingCenter.RefundVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RefundServiceImpl implements RefundService {
    @Resource
    RefundDao refundDao;

    @Override
    public List<RefundVo> list(RefundSearch refundSearch) {
        List<RefundVo> list = refundDao.list(refundSearch);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (RefundVo refundVo : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", refundVo.getGoodsId(), "goodsImg");
                refundVo.setGoodsImgList(imgByDate);
            }
        }
        return list;
    }
}

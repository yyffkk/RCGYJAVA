package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.OrderDao;
import com.api.manage.service.shoppingCenter.OrderService;
import com.api.model.shoppingCenter.OrderSearch;
import com.api.util.UploadUtil;
import com.api.vo.resources.VoResourcesImg;
import com.api.vo.shoppingCenter.GoodsVo;
import com.api.vo.shoppingCenter.OrderVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDao orderDao;

    @Override
    public List<OrderVo> list(OrderSearch orderSearch) {
        List<OrderVo> list = orderDao.list(orderSearch);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (OrderVo orderVo : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", orderVo.getGoodsId(), "goodsImg");
                orderVo.setGoodsImgList(imgByDate);
            }
        }
        return list;
    }
}

package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.OrderDao;
import com.api.manage.service.shoppingCenter.OrderService;
import com.api.model.businessManagement.SysUser;
import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.OrderSearch;
import com.api.util.UploadUtil;
import com.api.vo.resources.VoResourcesImg;
import com.api.vo.shoppingCenter.GoodsVo;
import com.api.vo.shoppingCenter.OrderVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private static Map<String,Object> map = null;
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

    @Override
    @Transactional
    public Map<String, Object> deliverGoods(Order order) {
        map = new HashMap<>();
        try {
            int status = orderDao.findStatusById(order.getId());
            if (status != 1){
                throw new RuntimeException("该状态不可发货");
            }

            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();


            order.setSendDate(new Date());
            order.setStatus(2);//2.已发货
            order.setSendOperator(sysUser.getId());//填写发货操作人

            int update = orderDao.deliverGoods(order);
            if (update <=0){
                throw new RuntimeException("发货失败");
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
        map.put("message","发货成功");
        map.put("status",true);
        return map;
    }
}

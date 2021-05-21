package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.OrderDao;
import com.api.manage.dao.shoppingCenter.RefundDao;
import com.api.manage.service.shoppingCenter.RefundService;
import com.api.model.businessManagement.SysUser;
import com.api.model.shoppingCenter.Order;
import com.api.model.shoppingCenter.RefundSearch;
import com.api.util.UploadUtil;
import com.api.vo.resources.VoResourcesImg;
import com.api.vo.shoppingCenter.OrderVo;
import com.api.vo.shoppingCenter.RefundVo;
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
public class RefundServiceImpl implements RefundService {
    private static Map<String,Object> map = null;
    @Resource
    RefundDao refundDao;
    @Resource
    OrderDao orderDao;

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

    @Override
    @Transactional
    public Map<String, Object> examine(Order order) {
        map = new HashMap<>();
        try {
            int status = orderDao.findStatusById(order.getId());
            if (status != 4){
                throw new RuntimeException("该状态不可审核");
            }

            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            order.setReviewer(sysUser.getId());//填入审核人id
            order.setAuditDate(new Date());//填入审核时间

            int update = refundDao.examine(order);
            if (update <= 0){
                throw new RuntimeException("审核失败");
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
        map.put("message","审核成功");
        map.put("status",true);
        return map;
    }
}

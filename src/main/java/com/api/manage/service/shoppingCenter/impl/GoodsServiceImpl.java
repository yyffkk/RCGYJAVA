package com.api.manage.service.shoppingCenter.impl;

import com.api.manage.dao.shoppingCenter.GoodsDao;
import com.api.manage.service.shoppingCenter.GoodsService;
import com.api.model.businessManagement.SysUser;
import com.api.model.shoppingCenter.Goods;
import com.api.model.shoppingCenter.GoodsIdAndStatus;
import com.api.model.shoppingCenter.GoodsSearch;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.resources.VoResourcesImg;
import com.api.vo.shoppingCenter.GoodsVo;
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
public class GoodsServiceImpl implements GoodsService {
    private static Map<String,Object> map = null;
    @Resource
    GoodsDao goodsDao;

    @Override
    public List<GoodsVo> list(GoodsSearch goodsSearch) {
        List<GoodsVo> list = goodsDao.list(goodsSearch);
        if (list != null && list.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (GoodsVo goodsVo : list) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", goodsVo.getId(), "goodsImg");
                goodsVo.setImgList(imgByDate);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public Map<String, Object> insert(Goods goods) {
        map = new HashMap<>();
        try {
            //获取登录用户信息
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            goods.setCreateId(sysUser.getId());
            goods.setCreateDate(new Date());
            goods.setIsDelete(1); //填写默认是否删除，1.非删
            goods.setCode(String.valueOf(new IdWorker(1, 1, 1).nextId()));
            goods.setDrawType(1); //填写提取方式，默认1.线下自提
            goods.setSubscribeNum(0); //填写默认订阅量 为0

            int insert = goodsDao.insert(goods);
            if (insert <0){
                throw new RuntimeException("添加失败");
            }
            UploadUtil uploadUtil = new UploadUtil();
            uploadUtil.saveUrlToDB(goods.getImgUrls(),"shopGoods",goods.getId(),"goodsImg","600",20,30);
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
        map.put("message","添加成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> unloading(Integer id) {
        map = new HashMap<>();
        GoodsIdAndStatus goodsIdAndStatus = new GoodsIdAndStatus();
        goodsIdAndStatus.setGoodsId(id);
        goodsIdAndStatus.setStatus(2);//2.下架

        int update = goodsDao.updateStatus(goodsIdAndStatus);
        if (update < 0){
            map.put("message","下架失败");
            map.put("status",false);
        }else {
            map.put("message","下架成功");
            map.put("status",true);
        }
        return map;
    }

    @Override
    public Map<String, Object> loading(Integer id) {
        map = new HashMap<>();
        GoodsIdAndStatus goodsIdAndStatus = new GoodsIdAndStatus();
        goodsIdAndStatus.setGoodsId(id);
        goodsIdAndStatus.setStatus(1);//1.上架

        int update = goodsDao.updateStatus(goodsIdAndStatus);
        if (update < 0){
            map.put("message","上架失败");
            map.put("status",false);
        }else {
            map.put("message","上架成功");
            map.put("status",true);
        }
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> delete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //根据商品主键id查询商品状态
                int status = goodsDao.findStatusById(id);
                if (status != 2){
                    throw new RuntimeException("请先下架商品");
                }

                //根据商品主键id查询是否预约
                int count = goodsDao.countAppointmentById(id);
                if (count > 0){
                    throw new RuntimeException("商品已被预约");
                }

                int update = goodsDao.delete(id);
                if (update < 0){
                    throw new RuntimeException("删除失败");
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
        map.put("message","删除成功");
        map.put("status",true);
        return map;
    }
}

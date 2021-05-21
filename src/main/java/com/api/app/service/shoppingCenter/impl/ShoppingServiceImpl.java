package com.api.app.service.shoppingCenter.impl;

import com.api.app.dao.shoppingCenter.ShoppingDao;
import com.api.app.service.shoppingCenter.ShoppingService;
import com.api.model.app.AppGoodsAppointment;
import com.api.model.app.AppGoodsIdAndAppointmentNum;
import com.api.model.app.AppGoodsIdAndUserId;
import com.api.util.IdWorker;
import com.api.util.UploadUtil;
import com.api.vo.app.AppCategoryVo;
import com.api.vo.app.AppGoodsDetailVo;
import com.api.vo.app.AppGoodsVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    private static Map<String,Object> map = null;
    @Resource
    ShoppingDao shoppingDao;

    @Override
    public Map<String, Object> list(Integer parentId) {
        map = new HashMap<>();
        List<AppCategoryVo> appCategoryVos = shoppingDao.list(parentId);
        if (appCategoryVos != null && appCategoryVos.size()>0){
            UploadUtil uploadUtil = new UploadUtil();
            for (AppCategoryVo appCategoryVo : appCategoryVos) {
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopCategory", appCategoryVo.getId(), "categoryImg");
                appCategoryVo.setImgList(imgByDate);
            }
        }
        map.put("data",appCategoryVos);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findTopGoods() {
        map = new HashMap<>();
        List<AppGoodsVo> appGoodsVos = shoppingDao.findTopGoods();
        if (appGoodsVos != null && appGoodsVos.size()>0){
            for (AppGoodsVo appGoodsVo : appGoodsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsVo.getId(), "goodsImg");
                appGoodsVo.setImgList(imgByDate);
            }
        }
        map.put("data",appGoodsVos);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public List<AppGoodsVo> findGoodsByCategoryId(Integer categoryId) {
        map = new HashMap<>();
        List<AppGoodsVo> appGoodsVos = shoppingDao.findGoodsByCategoryId(categoryId);
        if (appGoodsVos != null && appGoodsVos.size()>0){
            for (AppGoodsVo appGoodsVo : appGoodsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsVo.getId(), "goodsImg");
                appGoodsVo.setImgList(imgByDate);
            }
        }
        return appGoodsVos;
    }

    @Override
    public Map<String, Object> findDetailByGoodsId(Integer goodsId, Integer id) {
        map = new HashMap<>();
        AppGoodsDetailVo appGoodsDetailVo = shoppingDao.findDetailByGoodsId(goodsId);
        if (appGoodsDetailVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsDetailVo.getId(), "goodsImg");
            appGoodsDetailVo.setGoodsImgList(imgByDate);
            List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("shopSupplier", appGoodsDetailVo.getSupplierId(), "supplierImg");
            appGoodsDetailVo.setSupplierImgList(imgByDate1);

            //查询该用户是否有报名该商品
            AppGoodsIdAndUserId goodsIdAndUserId = new AppGoodsIdAndUserId();
            goodsIdAndUserId.setUserId(id);
            goodsIdAndUserId.setGoodsId(goodsId);
            int count = shoppingDao.countAppointmentByGIdAndUId(goodsIdAndUserId);
            if (count >0){
                appGoodsDetailVo.setIsSubscribe(1); //1.订阅
            }else {
                appGoodsDetailVo.setIsSubscribe(0); //0.没订阅
            }
        }
        map.put("data",appGoodsDetailVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> findTopGoodsBySupplierId(Integer supplierId) {
        map = new HashMap<>();
        List<AppGoodsVo> appGoodsVos = shoppingDao.findTopGoodsBySupplierId(supplierId);
        if (appGoodsVos != null && appGoodsVos.size()>0){
            for (AppGoodsVo appGoodsVo : appGoodsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsVo.getId(), "goodsImg");
                appGoodsVo.setImgList(imgByDate);
            }
        }
        map.put("data",appGoodsVos);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> goodsAppointment(AppGoodsAppointment appGoodsAppointment, Integer type, Integer id) {
        map = new HashMap<>();
        if (type == 4){//4.游客
            map.put("message","您的身份为游客，不可进行此操作");
            map.put("status",false);
            return map;
        }
        //查询该用户是否有报名该商品
        AppGoodsIdAndUserId goodsIdAndUserId = new AppGoodsIdAndUserId();
        goodsIdAndUserId.setUserId(id);
        goodsIdAndUserId.setGoodsId(appGoodsAppointment.getGoodsId());
        int count = shoppingDao.countAppointmentByGIdAndUId(goodsIdAndUserId);
        if (count >0){
            map.put("message","您已预约成功，不可进行再次进行该操作");
            map.put("status",false);
            return map;
        }

        appGoodsAppointment.setCreateId(id);
        appGoodsAppointment.setCreateDate(new Date());
        appGoodsAppointment.setStatus(1);//1.待发货
        appGoodsAppointment.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));//填入预约编号

        AppGoodsIdAndAppointmentNum appGoodsIdAndAppointmentNum = new AppGoodsIdAndAppointmentNum();
        appGoodsIdAndAppointmentNum.setGoodsId(appGoodsAppointment.getGoodsId());
        appGoodsIdAndAppointmentNum.setAppointmentNum(appGoodsAppointment.getNum());

        //累加商品预约量
        int update = shoppingDao.incGoodsAppointmentNum(appGoodsIdAndAppointmentNum);
        if (update <= 0){
            map.put("message","预约失败，库存已无");
            map.put("status",false);
            return map;
        }

        int insert = shoppingDao.goodsAppointment(appGoodsAppointment);
        if (insert >0){
            map.put("message","添加成功");
            map.put("status",true);
        }else {
            map.put("message","添加失败");
            map.put("status",false);
        }


        return map;
    }

    @Override
    public List<AppGoodsVo> goodsSearch(String searchName) {
        map = new HashMap<>();
        List<AppGoodsVo> appGoodsVos = shoppingDao.goodsSearch(searchName);
        if (appGoodsVos != null && appGoodsVos.size()>0){
            for (AppGoodsVo appGoodsVo : appGoodsVos) {
                UploadUtil uploadUtil = new UploadUtil();
                List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsVo.getId(), "goodsImg");
                appGoodsVo.setImgList(imgByDate);
            }
        }
        return appGoodsVos;
    }
}

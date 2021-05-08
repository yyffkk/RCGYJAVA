package com.api.app.service.shoppingCenter.impl;

import com.api.app.dao.shoppingCenter.ShoppingDao;
import com.api.app.service.shoppingCenter.ShoppingService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppCategoryVo;
import com.api.vo.app.AppGoodsDetailVo;
import com.api.vo.app.AppGoodsVo;
import com.api.vo.resources.VoResourcesImg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public Map<String, Object> findDetailByGoodsId(Integer goodsId) {
        map = new HashMap<>();
        AppGoodsDetailVo appGoodsDetailVo = shoppingDao.findDetailByGoodsId(goodsId);
        if (appGoodsDetailVo != null){
            UploadUtil uploadUtil = new UploadUtil();
            List<VoResourcesImg> imgByDate = uploadUtil.findImgByDate("shopGoods", appGoodsDetailVo.getId(), "goodsImg");
            appGoodsDetailVo.setGoodsImgList(imgByDate);
            List<VoResourcesImg> imgByDate1 = uploadUtil.findImgByDate("shopSupplier", appGoodsDetailVo.getSupplierId(), "supplierImg");
            appGoodsDetailVo.setSupplierImgList(imgByDate1);
        }
        map.put("data",appGoodsDetailVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }
}

package com.api.app.service.shoppingCenter.impl;

import com.api.app.dao.shoppingCenter.ShoppingDao;
import com.api.app.service.shoppingCenter.ShoppingService;
import com.api.util.UploadUtil;
import com.api.vo.app.AppCategoryVo;
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
}

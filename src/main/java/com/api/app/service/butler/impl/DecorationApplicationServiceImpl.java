package com.api.app.service.butler.impl;

import com.api.app.dao.butler.DecorationApplicationDao;
import com.api.app.service.butler.DecorationApplicationService;
import com.api.model.app.SearchAppDecoration;
import com.api.model.app.UserDecoration;
import com.api.model.app.UserIdAndEstateId;
import com.api.vo.app.AppDecorationAdditionalCostVo;
import com.api.vo.app.AppDecorationApplicationVo;
import com.api.vo.app.AppDecorationCostVo;
import com.api.vo.app.AppDecorationVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DecorationApplicationServiceImpl implements DecorationApplicationService {
    @Resource
    DecorationApplicationDao decorationApplicationDao;
    private static Map<String,Object> map = null;

    @Override
    public Map<String, Object> list(SearchAppDecoration searchAppDecoration) {
        map = new HashMap<>();
        List<AppDecorationVo> decorationVoList = decorationApplicationDao.list(searchAppDecoration);
        map.put("decorationVoList",decorationVoList);
        return map;
    }

    @Override
    public Map<String, Object> decorationCostDetail() {
        map = new HashMap<>();
        //查询装修押金,费用类型为：3.装修押金
        AppDecorationCostVo decorationCostVo = decorationApplicationDao.findDecorationDeposit();
        if (decorationCostVo != null){
            //根据 装修押金费用主键id 查询装修附加费用
            List<AppDecorationAdditionalCostVo> additionalCostVos = decorationApplicationDao.findDecorationAdditionalCost(decorationCostVo.getId());
            decorationCostVo.setAdditionalCostVos(additionalCostVos);
            //查询装修须知doc路径
            String url = decorationApplicationDao.findDecorationDocUrl();
            decorationCostVo.setDocUrl(url);
        }
        map.put("decorationCostVo",decorationCostVo);
        return map;
    }

    @Override
    public Map<String, Object> applicationDecoration(UserIdAndEstateId userIdAndEstateId) {
        map = new HashMap<>();
        //查询该用户是否有该房产的使用权
        int count = decorationApplicationDao.applicationDecoration(userIdAndEstateId);
        if (count >0){
            //根据用户id查询用户类型
            int type = decorationApplicationDao.findUserTypeByUserId(userIdAndEstateId.getId());
            UserDecoration userDecoration = new UserDecoration();
            if (type == 1){
                map.put("message","申请通过");
                map.put("status",true);
                userDecoration.setStatus(-3);
            }else{
                map.put("message","申请成功，请等待业主同意");
                map.put("status",false);
                userDecoration.setStatus(-1);
            }
            //添加装修信息
            userDecoration.setBuildingUnitEstateId(userIdAndEstateId.getEstateId());
            userDecoration.setResidentId(userIdAndEstateId.getId());
            userDecoration.setResidentType(type);
            userDecoration.setApplicationDate(new Date());
            //添加装修申请信息
            int insert = decorationApplicationDao.insertDecorationApplication(userDecoration);
            if (insert <= 0){
                map.put("message","申请失败");
                map.put("status",false);
            }
            map.put("keyId",userDecoration.getId());
        }else {
            map.put("message","您不能对该房产进行操作");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> update(UserDecoration userDecoration) {
        map = new HashMap<>();
        int update = decorationApplicationDao.update(userDecoration);
        if (update >0){
            map.put("message","信息完善成功");
            map.put("status",true);
        }else {
            map.put("message","信息完善失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> findApplicationDecoration(Integer id) {
        map = new HashMap<>();
        AppDecorationApplicationVo applicationVo = decorationApplicationDao.findApplicationDecoration(id);
        map.put("message","请求成功");
        map.put("data",applicationVo);
        map.put("status",true);
        return map;
    }
}

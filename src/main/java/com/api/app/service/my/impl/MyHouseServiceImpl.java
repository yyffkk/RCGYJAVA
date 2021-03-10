package com.api.app.service.my.impl;

import com.api.app.dao.login.AppLoginDao;
import com.api.app.dao.my.MyHouseDao;
import com.api.app.service.my.MyHouseService;
import com.api.model.basicArchives.UserResident;
import com.api.model.my.MyHouse;
import com.api.vo.my.MyHouseVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyHouseServiceImpl implements MyHouseService {
    @Resource
    MyHouseDao myHouseDao;
    @Resource
    AppLoginDao appLoginDao;
    private static Map<String,Object> map = null;

    @Override
    public List<MyHouseVo> list(Integer id) {
        return myHouseDao.list(id);
    }

    @Override
    @Transactional
    public Map<String, Object> authentication(MyHouse myHouse, Integer type) {
        map =  new HashMap<>();
        try {
            //判断不是游客后的身份信息
            if (type != 4 && myHouse.getType() != type){
                throw new RuntimeException("身份信息不对");
            }

            //判断该用户是否已有待审核记录存在
            int count = myHouseDao.countNotReviewed(myHouse.getResidentId());
            if (count >0){
                throw new RuntimeException("已有待审核记录，请等待完成");
            }
            UserResident userResident = new UserResident();
            userResident.setType(myHouse.getType());
            userResident.setName(myHouse.getName());
            userResident.setIdType(myHouse.getIdType());
            userResident.setIdNumber(myHouse.getIdNumber());
            userResident.setId(myHouse.getResidentId());
            //根据用户主键id 改变当前用户的住户类型,名称，证件类型，证件号码
            int update = myHouseDao.updateBaseInfoById(userResident);
            if (update <= 0){
                throw new RuntimeException("修改基础信息失败");
            }

            //添加审核状态（1.未审核，3.审核失败，4.审核成功）
            myHouse.setStatus(1);
            //填入是否删除，1.非删 0.删除 默认为1.非删
            myHouse.setIsDelete(1);
            //填入创建时间
            myHouse.setCreateDate(new Date());
            //添加住户房产审核信息
            int insert2 = appLoginDao.insertResidentEstateExamine(myHouse);
            if (insert2 <= 0){
                throw new RuntimeException("添加住户房产审核信息");
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
        map.put("message","提交成功,请等待审核");
        map.put("status",true);
        return map;
    }
}

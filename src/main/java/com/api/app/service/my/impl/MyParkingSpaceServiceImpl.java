package com.api.app.service.my.impl;

import com.api.app.dao.my.MyParkingSpaceDao;
import com.api.app.service.my.MyParkingSpaceService;
import com.api.model.my.MyParkingSpace;
import com.api.vo.my.MyParkingSpaceVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MyParkingSpaceServiceImpl implements MyParkingSpaceService {
    @Resource
    MyParkingSpaceDao myParkingSpaceDao;
    private static Map<String,Object> map = null;

    @Override
    public List<MyParkingSpaceVo> list(Integer id) {
        return myParkingSpaceDao.list(id);
    }

    @Override
    @Transactional
    public Map<String, Object> authentication(MyParkingSpace myParkingSpace) {
        map = new HashMap<>();
        try {
            //判断该用户是否已有待审核记录存在
            int count = myParkingSpaceDao.countNotReviewed(myParkingSpace.getResidentId());
            if (count >0){
                throw new RuntimeException("已有待审核记录，请等待完成");
            }
            //添加车位审核信息
            myParkingSpace.setStatus(1); //填入审核状态，默认1.审核中
            myParkingSpace.setIsDelete(1); //填入是否删除，默认1.非删
            myParkingSpace.setCreateDate(new Date()); //填入创建时间
            int insert = myParkingSpaceDao.insertParkingSpaceExamine(myParkingSpace);
            if (insert <= 0){
                throw new RuntimeException("添加住户房产审核信息失败");
            }
        } catch (RuntimeException e) {
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
        map.put("message","提交成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                //判断是否是审核中状态
                int status = myParkingSpaceDao.findStatusById(id);
                if (status == 1){
                    throw new RuntimeException("审核中，无法删除");
                }
                int update = myParkingSpaceDao.falseDelete(id);
                if (update <= 0){
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

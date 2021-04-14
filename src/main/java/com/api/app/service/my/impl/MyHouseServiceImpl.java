package com.api.app.service.my.impl;

import com.api.app.dao.login.AppLoginDao;
import com.api.app.dao.my.MyHouseDao;
import com.api.app.service.my.MyHouseService;
import com.api.model.basicArchives.ResidentIdAndEstateId;
import com.api.model.basicArchives.UserResident;
import com.api.model.my.MyHouse;
import com.api.vo.my.MyHouseEstateInfoVo;
import com.api.vo.my.MyHouseFBIVo;
import com.api.vo.my.MyHouseResidentInfoVo;
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
    public Map<String, Object> list(Integer id) {
        map = new HashMap<>();
        List<MyHouseVo> list = myHouseDao.list(id);
        map.put("data",list);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> authentication(MyHouse myHouse, Integer type) {
        map =  new HashMap<>();
        try {
            // TODO 去除该判断，使得用户可以同时拥有两种身份
            //当既不是游客，用户类型又不相等时，抛出错误；是游客继续执行，类型相等继续执行
            if (type != 4 && myHouse.getType() != type){
                throw new RuntimeException("身份信息不对，请联系管理员");
            }

            //判断该用户是否已有审核中记录存在
            int count = myHouseDao.countNotReviewed(myHouse.getResidentId());
            if (count >0){
                throw new RuntimeException("已有审核中记录，请等待完成");
            }

            //判断是否已有审核成功的房产id
            List<Integer> ids2 = myHouseDao.countSuccessReviewed(myHouse.getResidentId());
            if (ids2.contains(myHouse.getEstateId())){
                throw new RuntimeException("已有该房产的审核成功并且没有删除的记录");
            }

            //当数据库存在该房屋信息时，直接审核成功
            //根据用户主键id查询数据库存在的关联的房房产id集合
            List<Integer> ids = myHouseDao.findDBEstaIdByResidentId(myHouse.getResidentId());
            //根据用户主键id查询数据库住户信息
            MyHouseResidentInfoVo residentInfoVo = myHouseDao.findSBResidentInfoByResidentId(myHouse.getResidentId());
            //判断填入数据与数据库已知数据是否相同
            // （1）用户类型不为2.审核亲属，（2）该用户拥有该房产的拥有权，（3）用户证件类型与数据库一致，（4）用户姓名与数据库一致，（5）用户住户类型与数据库一致
            if (myHouse.getType() != 2 && ids.contains(myHouse.getEstateId()) && residentInfoVo.getIdNumber().equals(myHouse.getIdNumber())
                    && residentInfoVo.getName().equals(myHouse.getName()) && residentInfoVo.getIdType().equals(myHouse.getIdType())){
                //系统自动审核成功
                //根据用户主键id和房产id查询房产信息
                ResidentIdAndEstateId residentIdAndEstateId = new ResidentIdAndEstateId();
                residentIdAndEstateId.setResidentId(myHouse.getResidentId());
                residentIdAndEstateId.setEstateId(myHouse.getEstateId());
                MyHouseEstateInfoVo estateInfoVo = myHouseDao.findEstateInfoByResidentId(residentIdAndEstateId);
                //添加有效时间开始（只限租客）
                myHouse.setEffectiveTimeStart(estateInfoVo.getEffectiveTimeStart());
                //添加有效时间结束（只限租客）
                myHouse.setEffectiveTimeEnd(estateInfoVo.getEffectiveTimeEnd());
                //添加审核状态（1.未审核，3.审核失败，4.审核成功）
                myHouse.setStatus(4);
                //填写审核人id（系统自动审核成功为-1）
                myHouse.setReviewer(-1);
                //填写审核时间（系统自动审核成功为当前时间）
                myHouse.setReviewerDate(new Date());
                //填入是否删除，1.非删 0.删除 默认为1.非删
                myHouse.setIsDelete(1);
                //填入创建时间
                myHouse.setCreateDate(new Date());
                //添加住户房产审核信息
                int insert2 = appLoginDao.insertResidentEstateExamine(myHouse);
                if (insert2 <= 0){
                    throw new RuntimeException("添加住户房产审核信息失败");
                }
            }else {
                //系统自动审核失败
                //添加审核状态（1.未审核，3.审核失败，4.审核成功）
                myHouse.setStatus(1);
                //填写审核人id（系统自动审核失败为null）
                myHouse.setReviewer(null);
                //填写审核时间(系统自动审核失败为null)
                myHouse.setReviewerDate(null);
                //填入是否删除，1.非删 0.删除 默认为1.非删
                myHouse.setIsDelete(1);
                //填入创建时间
                myHouse.setCreateDate(new Date());
                //添加住户房产审核信息
                int insert2 = appLoginDao.insertResidentEstateExamine(myHouse);
                if (insert2 <= 0){
                    throw new RuntimeException("添加住户房产审核信息失败");
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
        map.put("message","提交成功,请等待审核");
        map.put("status",true);
        return map;
    }

    @Override
    @Transactional
    public Map<String, Object> falseDelete(int[] ids,Integer residentId) {
        map = new HashMap<>();
        try {
            for (int id : ids) {
                int residentIdById = myHouseDao.findResidentIdById(id);
                //判断用户是否是该审核用户
                if (residentIdById != residentId){
                    throw new RuntimeException("登录用户错误");
                }
                //判断是否是审核中状态
                int status = myHouseDao.findStatusById(id);
                if (status == 1){ //审核中
                    throw new RuntimeException("审核中，无法删除");
                }

                if (status == 4) { //审核成功
                    //根据房产审核表主键id查询审核房产id
                    Integer estateId = myHouseDao.findEstateIdById(id);
                    //根据住户id查询app当前选中的房产id
                    Integer nowEstateId = myHouseDao.findNowEstateIdByResidentId(residentId);
                    //判断该用户的当前选择的房产id是否是该审核成功的房产id
                    if (estateId.equals(nowEstateId)){
                        throw new RuntimeException("该房屋已选中，不可删除");
                    }
                }

                int update = myHouseDao.falseDelete(id);
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

    @Override
    public Map<String, Object> findById(Integer estateExamineId) {
        map = new HashMap<>();
        //根据房产审核表主键id查询再次认证回显信息
        MyHouseFBIVo myHouseFBIVo = myHouseDao.findById(estateExamineId);
        map.put("data",myHouseFBIVo);
        map.put("message","请求成功");
        map.put("status",true);
        return map;
    }
}

package com.api.butlerApp.service.jurisdiction.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerKeyDao;
import com.api.butlerApp.service.jurisdiction.ButlerKeyService;
import com.api.manage.dao.operationManagement.SysKeyBorrowDao;
import com.api.model.butlerApp.ButlerKeyBorrow;
import com.api.model.butlerApp.ButlerKeyIdAndBorrowerId;
import com.api.model.butlerApp.ButlerKeySearch;
import com.api.model.butlerApp.ButlerRecordSearch;
import com.api.util.IdWorker;
import com.api.vo.butlerApp.ButlerKeyVo;
import com.api.vo.butlerApp.ButlerRecordVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerKeyServiceImpl implements ButlerKeyService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerKeyDao butlerKeyDao;
    @Resource
    SysKeyBorrowDao sysKeyBorrowDao;

    @Override
    public List<ButlerKeyVo> list(ButlerKeySearch butlerKeySearch) {
        List<ButlerKeyVo> list = butlerKeyDao.list(butlerKeySearch);
        if (list != null && list.size()>0){
            for (ButlerKeyVo butlerKeyVo : list) {
                //查询当前已借出的钥匙数量(当状态为2，4，5时，视为已借出)
                int loanableNum = sysKeyBorrowDao.countLoanableKeyNum(butlerKeyVo.getId());
                //填入可申请钥匙数量
                butlerKeyVo.setLoanableNum(butlerKeyVo.getTotalNum() - loanableNum);

                //填入状态
                if (butlerKeyVo.getTotalNum() > butlerKeyVo.getLoanableNum()){
                    //当钥匙总数 大于 钥匙借取数量
                    butlerKeyVo.setStatus(1);//1.可申请
                }else {
                    butlerKeyVo.setStatus(3);//3.钥匙已空
                }

                //判断该用户是否使用中
                ButlerKeyIdAndBorrowerId keyIdAndBorrowerId = new ButlerKeyIdAndBorrowerId();
                keyIdAndBorrowerId.setKeyId(butlerKeyVo.getId());//填入钥匙主键id
                keyIdAndBorrowerId.setBorrowerId(butlerKeySearch.getId());//填入借取人主键id

                Date createDate = butlerKeyDao.findCreateDateByKeyIdAndBorrowerId(keyIdAndBorrowerId);
                if (createDate != null){
                    butlerKeyVo.setStatus(2);//2.使用中
                    butlerKeyVo.setCreateDate(createDate);
                }


            }
        }
        return list;
    }

    @Override
    public List<ButlerKeyVo> noReturnList(ButlerKeySearch butlerKeySearch) {
        List<ButlerKeyVo> list = butlerKeyDao.noReturnList(butlerKeySearch);
        if (list != null && list.size()>0){
            for (ButlerKeyVo butlerKeyVo : list) {
                //查询当前已借出的钥匙数量(当状态为2,4,5时，视为已借出)
                int loanableNum = sysKeyBorrowDao.countLoanableKeyNum(butlerKeyVo.getId());
                //填入可申请钥匙数量
                butlerKeyVo.setLoanableNum(butlerKeyVo.getTotalNum() - loanableNum);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> apply(ButlerKeyBorrow butlerKeyBorrow, Integer id) {
        map = new HashMap<>();

        butlerKeyBorrow.setBorrower(id);//填入借取人
        butlerKeyBorrow.setCreateDate(new Date());//填入创建时间
        butlerKeyBorrow.setCode(String.valueOf(new IdWorker(1,1,1).nextId()));
        butlerKeyBorrow.setStatus(1);//填入状态 ,1.待审核

        ButlerKeyIdAndBorrowerId keyIdAndBorrowerId = new ButlerKeyIdAndBorrowerId();
        keyIdAndBorrowerId.setKeyId(butlerKeyBorrow.getKeyId());//填入钥匙主键id
        keyIdAndBorrowerId.setBorrowerId(id);//填入借取人主键id
        Date date = butlerKeyDao.findCreateDateByKeyIdAndBorrowerId(keyIdAndBorrowerId);
        if (date != null){
            map.put("message","已获取该钥匙，不可申请");
            map.put("status",false);
            return map;
        }

        //根据钥匙主键id查询钥匙信息
        Integer num = butlerKeyDao.findNumById(butlerKeyBorrow.getKeyId());
        if (num <= 0){
            map.put("message","钥匙数量不足，不可申请");
            map.put("status",false);
            return map;
        }

        int insert = butlerKeyDao.apply(butlerKeyBorrow);
        if (insert >0){
            map.put("message","申请成功");
            map.put("status",true);
        }else {
            map.put("message","申请失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public Map<String, Object> returnKey(Integer keyId, Integer id) {
        map = new HashMap<>();
        ButlerKeyIdAndBorrowerId keyIdAndBorrowerId = new ButlerKeyIdAndBorrowerId();
        keyIdAndBorrowerId.setKeyId(keyId);//填入钥匙主键id
        keyIdAndBorrowerId.setBorrowerId(id);//填入借取人主键id

        Date date = butlerKeyDao.findCreateDateByKeyIdAndBorrowerId(keyIdAndBorrowerId);
        if (date == null){
            map.put("message","未借取该钥匙，不可归还");
            map.put("status",false);
            return map;
        }

        ButlerKeyBorrow butlerKeyBorrow = new ButlerKeyBorrow();
        butlerKeyBorrow.setKeyId(keyId); //填入钥匙主键id
        butlerKeyBorrow.setBorrower(id); //填入借取人主键id
        butlerKeyBorrow.setReturnDate(new Date()); //填入归还时间
        butlerKeyBorrow.setStatus(4);//4.已归还

        int update = butlerKeyDao.returnKey(butlerKeyBorrow);
        if (update >0){
            map.put("message","归还成功");
            map.put("status",true);
        }else {
            map.put("message","归还失败");
            map.put("status",false);
        }
        return map;
    }

    @Override
    public List<ButlerRecordVo> record(ButlerRecordSearch butlerRecordSearch) {
        return butlerKeyDao.record(butlerRecordSearch);
    }
}

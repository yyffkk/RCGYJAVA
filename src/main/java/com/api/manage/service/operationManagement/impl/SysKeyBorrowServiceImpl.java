package com.api.manage.service.operationManagement.impl;

import com.api.butlerApp.dao.jurisdiction.ButlerKeyDao;
import com.api.manage.dao.operationManagement.SysKeyBorrowDao;
import com.api.manage.service.operationManagement.SysKeyBorrowService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerApp.ButlerKeyIdAndBorrowerId;
import com.api.model.operationManagement.KeyBorrow;
import com.api.model.operationManagement.SearchKeyBorrow;
import com.api.vo.operationManagement.VoKeyBorrow;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysKeyBorrowServiceImpl implements SysKeyBorrowService {
    private static Map<String,Object> map = null;
    @Resource
    SysKeyBorrowDao sysKeyBorrowDao;
    @Resource
    ButlerKeyDao butlerKeyDao;

    @Override
    public List<VoKeyBorrow> list(SearchKeyBorrow searchKeyBorrow) {
        //当前查出的钥匙数量是钥匙总数
        List<VoKeyBorrow> list = sysKeyBorrowDao.list(searchKeyBorrow);
        if (list != null && list.size()>0){
            for (VoKeyBorrow voKeyBorrow : list) {
                //查询当前已借出的钥匙数量(当状态为2时，视为已借出)
                int loanableNum = sysKeyBorrowDao.countLoanableKeyNum(voKeyBorrow.getKeyId());
                voKeyBorrow.setLoanableNum(voKeyBorrow.getLoanableNum() - loanableNum);
            }
        }
        return list;
    }

    @Override
    public Map<String, Object> examine(KeyBorrow keyBorrow) {
        map = new HashMap<>();

        KeyBorrow keyBorrow1 = sysKeyBorrowDao.findKeyBorrowById(keyBorrow.getId());

        ButlerKeyIdAndBorrowerId keyIdAndBorrowerId = new ButlerKeyIdAndBorrowerId();
        keyIdAndBorrowerId.setKeyId(keyBorrow1.getKeyId());
        keyIdAndBorrowerId.setBorrowerId(keyBorrow1.getBorrower());
        Date date = butlerKeyDao.findCreateDateByKeyIdAndBorrowerId(keyIdAndBorrowerId);
        if (date != null){
            map.put("message","该用户已获取该钥匙，不可申请通过");
            map.put("status",false);
            return map;

        }

        //根据审核主键id 查询审核状态
        int status = sysKeyBorrowDao.findStatusById(keyBorrow.getId());
        if (status != 1){
            map.put("message","该记录已审核");
            map.put("status",false);
            return map;
        }

        //获取登录用户信息
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser = (SysUser) subject.getPrincipal();

        keyBorrow.setReviewer(sysUser.getId());
        keyBorrow.setAuditDate(new Date());

        int update = sysKeyBorrowDao.examine(keyBorrow);
        if (update >0){
            map.put("message","操作成功");
            map.put("status",true);
        }else {
            map.put("message","操作失败");
            map.put("status",false);
        }
        return map;
    }
}

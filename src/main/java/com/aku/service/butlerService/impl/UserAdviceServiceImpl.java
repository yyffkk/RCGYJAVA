package com.aku.service.butlerService.impl;

import com.aku.dao.butlerService.UserAdviceDao;
import com.aku.model.butlerService.SearchUserAdvice;
import com.aku.service.butlerService.UserAdviceService;
import com.aku.vo.butlerService.VoUserAdvice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserAdviceServiceImpl implements UserAdviceService {
    @Resource
    UserAdviceDao userAdviceDao;

    @Override
    public List<VoUserAdvice> list(SearchUserAdvice searchUserAdvice) {
        List<VoUserAdvice> list = userAdviceDao.list(searchUserAdvice);
        for (VoUserAdvice voUserAdvice : list) {
            //根据咨询建议表主键id 查询 建议反馈表信息数量
            int num = userAdviceDao.countDetailByAdviceId(voUserAdvice.getId());
            if (num >0){
                //1.已反馈
                voUserAdvice.setStatus(1);
            }else {
                //0.未反馈
                voUserAdvice.setStatus(0);
            }
        }
        return list;
    }
}

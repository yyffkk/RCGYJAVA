package com.api.service.butlerService.impl;

import com.api.dao.butlerService.BorrowDao;
import com.api.model.butlerService.SearchBorrow;
import com.api.service.butlerService.BorrowService;
import com.api.vo.butlerService.VoBorrow;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowDao borrowDao;

    @Override
    public List<VoBorrow> list(SearchBorrow searchBorrow) {
        List<VoBorrow> list = borrowDao.list(searchBorrow);
        if (list != null && list.size()>0){
            for (VoBorrow voBorrow : list) {
                //计算出出借时长
                long hour = (new Date().getTime() - voBorrow.getBeginDate().getTime())/(60*60*1000);
                //传入出借时长
                voBorrow.setBorrowDate(hour);
            }
        }
        return list;
    }
}

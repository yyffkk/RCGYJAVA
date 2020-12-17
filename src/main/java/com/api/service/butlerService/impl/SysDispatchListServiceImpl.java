package com.api.service.butlerService.impl;

import com.api.dao.butlerService.SysDispatchListDao;
import com.api.model.butlerService.SearchDispatchList;
import com.api.service.butlerService.SysDispatchListService;
import com.api.vo.butlerService.VoDispatchList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDispatchListServiceImpl implements SysDispatchListService {
    @Resource
    SysDispatchListDao sysDispatchListDao;

    @Override
    public List<VoDispatchList> list(SearchDispatchList searchDispatchList) {
        List<VoDispatchList> list = null;
        if (searchDispatchList.getType() != null){
            if (searchDispatchList.getType() == 1){
                list = sysDispatchListDao.list(searchDispatchList);
            }else {
                //其他情况未做，为空
            }
        }else {
            list = sysDispatchListDao.list(searchDispatchList);
        }

        return list;
    }
}

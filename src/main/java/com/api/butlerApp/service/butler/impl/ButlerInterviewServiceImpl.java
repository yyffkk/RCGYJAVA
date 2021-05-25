package com.api.butlerApp.service.butler.impl;

import com.api.butlerApp.dao.butler.ButlerInterviewDao;
import com.api.butlerApp.service.butler.ButlerInterviewService;
import com.api.model.butlerApp.ButlerInterviewSearch;
import com.api.model.operationManagement.Interview;
import com.api.vo.butlerApp.ButlerInterviewVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ButlerInterviewServiceImpl implements ButlerInterviewService {
    private static Map<String,Object> map = null;
    @Resource
    ButlerInterviewDao butlerInterviewDao;

    @Override
    public List<ButlerInterviewVo> list(ButlerInterviewSearch butlerInterviewSearch) {
        return butlerInterviewDao.list(butlerInterviewSearch);
    }

    @Override
    public Map<String, Object> feedBack(Interview interview, Integer id) {
        map = new HashMap<>();
        interview.setInterviewers(id);
        interview.setFeedbackDate(new Date());
        interview.setStatus(2);//2.已访谈

        int update = butlerInterviewDao.feedBack(interview);
        if (update >0){
            map.put("message","回复成功");
            map.put("status",true);
        }else {
            map.put("message","回复失败");
            map.put("status",false);
        }


        return map;
    }
}

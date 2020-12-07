package com.aku.service.butlerService;


import com.aku.model.butlerService.SearchUserAdvice;
import com.aku.model.butlerService.SysAdvice;
import com.aku.vo.butlerService.VoUserAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ComplaintPraiseService {
    List<VoUserAdvice> list(SearchUserAdvice searchUserAdvice);


    Map<String, Object> findById(Integer id);

    Map<String, Object> insertAdvice(SysAdvice sysAdvice, HttpServletRequest request);

    Map<String, Object> countComplaintNew();

    Map<String, Object> countPraiseNew();

    Map<String, Object> delete(int[] ids);

    Map<String, Object> falseDelete(int[] ids);
}

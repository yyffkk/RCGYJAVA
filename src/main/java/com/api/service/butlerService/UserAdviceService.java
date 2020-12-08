package com.api.service.butlerService;

import com.api.model.butlerService.SearchUserAdvice;
import com.api.model.butlerService.SysAdvice;
import com.api.model.butlerService.SysAdviceDetail;
import com.api.vo.butlerService.VoUserAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserAdviceService {
    List<VoUserAdvice> list(SearchUserAdvice searchUserAdvice);

    Map<String, Object> insertDetail(SysAdviceDetail sysAdviceDetail);

    Map<String, Object> insertAdvice(SysAdvice sysAdvice, HttpServletRequest request);

    Map<String, Object> delete(int[] ids);

    Map<String, Object> falseDelete(int[] ids);

    Map<String, Object> findById(Integer id);

    Map<String, Object> countAdviceNew();

    Map<String, Object> countConsultNew();
}

package com.api.manage.service.chargeManagement;

import com.api.model.chargeManagement.SearchChargesTemplateDetail;
import com.api.model.chargeManagement.SysChargesTemplateDetail;
import com.api.vo.chargeManagement.VoChargesTemplateDetail;
import com.api.vo.chargeManagement.VoFindByIdChargesTemplateDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface SysChargesTemplateDetailService {
    List<VoChargesTemplateDetail> list(SearchChargesTemplateDetail searchChargesTemplateDetail);

    Map<String, Object> insert(SysChargesTemplateDetail sysChargesTemplateDetail);

    Map<String,Object> findById(Integer id);

    Map<String, Object> update(SysChargesTemplateDetail sysChargesTemplateDetail);

    Map<String, Object> delete(int[] ids);

    void export(HttpServletRequest request, HttpServletResponse response,Integer chargesTemplateId);

    Map<String, Object> isEnable(Integer id);
}

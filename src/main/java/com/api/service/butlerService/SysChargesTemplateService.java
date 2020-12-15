package com.api.service.butlerService;

import com.api.model.butlerService.ChargesTemplate;
import com.api.vo.butlerService.VoChargesTemplate;

import java.util.List;
import java.util.Map;

public interface SysChargesTemplateService {
    List<VoChargesTemplate> list();

    Map<String, Object> insert(ChargesTemplate chargesTemplate);

    Map<String, Object> delete(int[] ids);

    VoChargesTemplate findById(Integer id);

    Map<String, Object> update(ChargesTemplate chargesTemplate);

    Map<String, Object> enable(Integer id);

    Map<String, Object> disable(Integer id);
}

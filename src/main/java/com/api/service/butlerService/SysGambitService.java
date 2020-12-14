package com.api.service.butlerService;

import com.api.model.butlerService.SearchGambit;
import com.api.model.butlerService.SysGambit;
import com.api.vo.butlerService.VoFindByIdGambit;
import com.api.vo.butlerService.VoGambit;

import java.util.List;
import java.util.Map;

public interface SysGambitService {
    List<VoGambit> list(SearchGambit searchGambit);

    Map<String, Object> insert(SysGambit sysGambit);

    VoFindByIdGambit findById(Integer id);

    Map<String, Object> update(SysGambit sysGambit);

    Map<String, Object> falseDelete(int[] ids);

    Map<String, Object> enableGambit(Integer id);

    Map<String, Object> disableGambit(Integer id);
}

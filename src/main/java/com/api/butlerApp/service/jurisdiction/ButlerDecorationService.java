package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerDecorationSearch;
import com.api.vo.butlerApp.ButlerDecorationVo;

import java.util.List;
import java.util.Map;

public interface ButlerDecorationService {
    List<ButlerDecorationVo> list(ButlerDecorationSearch decorationSearch);

    Map<String, Object> findById(Integer decorationId);
}

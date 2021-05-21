package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerHygieneSearch;
import com.api.vo.butlerApp.ButlerHygieneVo;

import java.util.List;

public interface ButlerHygieneService {
    List<ButlerHygieneVo> list(ButlerHygieneSearch butlerHygieneSearch);
}

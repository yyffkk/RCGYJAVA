package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerInspectionSearch;
import com.api.vo.butlerApp.ButlerInspectionVo;

import java.util.List;

public interface ButlerInspectionDao {
    List<ButlerInspectionVo> list(ButlerInspectionSearch butlerInspectionSearch);
}

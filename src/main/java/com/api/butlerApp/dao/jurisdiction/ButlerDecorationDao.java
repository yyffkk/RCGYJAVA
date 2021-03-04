package com.api.butlerApp.dao.jurisdiction;

import com.api.model.butlerApp.ButlerDecorationSearch;
import com.api.vo.butlerApp.ButlerDecorationVo;

import java.util.List;

public interface ButlerDecorationDao {
    List<ButlerDecorationVo> list(ButlerDecorationSearch decorationSearch);
}

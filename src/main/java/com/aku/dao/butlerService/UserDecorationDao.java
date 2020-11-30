package com.aku.dao.butlerService;

import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.vo.butlerService.VoUserDecoration;

import java.util.List;

public interface UserDecorationDao {
    List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration);
}

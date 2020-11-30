package com.aku.service.butlerService;

import com.aku.model.butlerService.SearchUserDecoration;
import com.aku.vo.butlerService.VoUserDecoration;

import java.util.List;

public interface UserDecorationService {
    List<VoUserDecoration> list(SearchUserDecoration searchUserDecoration);
}

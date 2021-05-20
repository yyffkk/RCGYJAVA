package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerKeySearch;
import com.api.vo.butlerApp.ButlerKeyVo;

import java.util.List;

public interface ButlerKeyService {
    List<ButlerKeyVo> list(ButlerKeySearch butlerKeySearch);

    List<ButlerKeyVo> noReturnList(ButlerKeySearch butlerKeySearch);
}

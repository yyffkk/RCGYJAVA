package com.api.butlerApp.service.jurisdiction;

import com.api.model.butlerApp.ButlerKeyBorrow;
import com.api.model.butlerApp.ButlerKeySearch;
import com.api.model.butlerApp.ButlerRecordSearch;
import com.api.vo.butlerApp.ButlerKeyVo;
import com.api.vo.butlerApp.ButlerRecordVo;

import java.util.List;
import java.util.Map;

public interface ButlerKeyService {
    List<ButlerKeyVo> list(ButlerKeySearch butlerKeySearch);

    List<ButlerKeyVo> noReturnList(ButlerKeySearch butlerKeySearch);

    Map<String, Object> apply(ButlerKeyBorrow butlerKeyBorrow, Integer id);

    Map<String, Object> returnKey(Integer keyId, Integer id);

    List<ButlerRecordVo> record(ButlerRecordSearch butlerRecordSearch);
}

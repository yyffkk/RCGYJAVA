package com.api.app.service.butler;

import com.api.model.app.AppArticleOut;
import com.api.model.app.UserIdAndArticleOutId;
import com.api.vo.app.AppArticleOutVo;

import java.util.List;
import java.util.Map;

public interface AppArticleOutService {
    Map<String, Object> submit(AppArticleOut appArticleOut);

    Map<String, Object> getMovingCompanyTel();

    List<AppArticleOutVo> list(Integer id);

    Map<String, Object> falseDelete(int[] ids, Integer id);

    Map<String, Object> getQRCode(UserIdAndArticleOutId userIdAndArticleOutId);
}

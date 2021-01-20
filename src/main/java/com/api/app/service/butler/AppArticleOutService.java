package com.api.app.service.butler;

import com.api.model.app.AppArticleOut;
import java.util.Map;

public interface AppArticleOutService {
    Map<String, Object> submit(AppArticleOut appArticleOut);

    Map<String, Object> getMovingCompanyTel();
}

package com.api.app.service.homePage;

import java.util.Map;

public interface AppSearchService {
    Map<String, Object> search(String searchName, Integer id);
}

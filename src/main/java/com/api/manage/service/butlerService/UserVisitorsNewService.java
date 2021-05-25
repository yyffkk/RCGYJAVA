package com.api.manage.service.butlerService;

import com.api.model.butlerService.SearchVisitorsNew;
import com.api.vo.butlerService.VoVisitorsNew;

import java.util.List;

public interface UserVisitorsNewService {
    List<VoVisitorsNew> list(SearchVisitorsNew searchVisitorsNew);
}

package com.api.app.service.butler;

import com.api.model.app.AppUserQRVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsInvite;
import com.api.model.app.AppUserVisitorsInviteSubmit;
import com.api.model.app.SearchAppVisitorInvite;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AppVisitorInviteService {
    List<AppUserVisitorsInvite> list(SearchAppVisitorInvite searchAppVisitorInvite);

    Map<String, Object> share(AppUserVisitorsInvite visitorsInvite);

    Map<String, Object> againShare(Integer visitorsInviteId);

    Map<String, Object> findByUrlCode(String code);

    Map<String, Object> submit(AppUserVisitorsInviteSubmit visitorsInviteSubmit);

    Map<String, Object> QRSubmit(AppUserQRVisitorsInviteSubmit qrVisitorsInviteSubmit);
}

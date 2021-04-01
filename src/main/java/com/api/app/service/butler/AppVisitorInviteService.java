package com.api.app.service.butler;

import com.api.model.app.AppUserQRVisitorsInviteSubmit;
import com.api.model.app.AppUserVisitorsInvite;
import com.api.model.app.AppUserVisitorsInviteSubmit;

import java.util.Map;

public interface AppVisitorInviteService {
    Map<String, Object> share(AppUserVisitorsInvite visitorsInvite);

    Map<String, Object> findByUrlCode(String code);

    Map<String, Object> submit(AppUserVisitorsInviteSubmit visitorsInviteSubmit);

    Map<String, Object> QRSubmit(AppUserQRVisitorsInviteSubmit qrVisitorsInviteSubmit);
}

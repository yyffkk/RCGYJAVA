package com.api.manage.service.message;

import com.api.model.message.ManageSysMessage;
import com.api.model.message.SearchManageSysMessage;

import java.util.List;
import java.util.Map;

public interface ManageSysMessageService {
    List<ManageSysMessage> list(SearchManageSysMessage searchManageSysMessage);

    Map<String, Object> read(Integer manageSysMessageId);

    Map<String, Object> allRead();
}

package com.api.manage.service.message;

import com.api.model.message.ManageSysMessage;
import com.api.model.message.SearchManageSysMessage;

import java.util.List;

public interface ManageSysMessageService {
    List<ManageSysMessage> list(SearchManageSysMessage searchManageSysMessage);
}

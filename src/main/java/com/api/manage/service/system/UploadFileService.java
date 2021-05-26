package com.api.manage.service.system;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadFileService {
    Map<String,Object> UploadEstateFile(MultipartFile file);

    Map<String, Object> UploadServiceBrowsingFile(MultipartFile file);
}

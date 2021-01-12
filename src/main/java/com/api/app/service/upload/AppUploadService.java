package com.api.app.service.upload;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface AppUploadService {
    Map<String, Object> appHeadSculpture(MultipartFile file);
}

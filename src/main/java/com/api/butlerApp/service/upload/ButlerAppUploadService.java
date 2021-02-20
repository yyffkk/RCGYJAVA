package com.api.butlerApp.service.upload;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ButlerAppUploadService {
    Map<String, Object> butlerAppHeadSculpture(MultipartFile file);
}

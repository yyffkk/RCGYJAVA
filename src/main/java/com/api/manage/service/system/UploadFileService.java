package com.api.manage.service.system;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadFileService {
    Map<String, Object> UploadBuildingFile(MultipartFile file);

    Map<String, Object> UploadBuildingUnitFile(MultipartFile file);

    Map<String,Object> UploadEstateFile(MultipartFile file);

    Map<String, Object> UploadServiceBrowsingFile(MultipartFile file);

    Map<String, Object> UploadKeyFile(MultipartFile file);

    Map<String, Object> UploadGreenAreaFile(MultipartFile file);

    Map<String, Object> UploadDailyPaymentFile(MultipartFile file);
}

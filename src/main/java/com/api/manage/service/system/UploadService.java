package com.api.manage.service.system;


import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadService {

    Map<String, Object> uploadArticle(MultipartFile file);

    Map<String, Object> uploadGambit(MultipartFile file);

    Map<String, Object> uploadVoteTitle(MultipartFile file);

    Map<String, Object> uploadVoteCandidate(MultipartFile file);

    Map<String, Object> uploadVoucher(MultipartFile file);

    Map<String, Object> uploadActivity(MultipartFile file);

    Map<String, Object> uploadAnnouncement(MultipartFile file);

    Map<String, Object> uploadAnnouncementDoc(MultipartFile file);

    Map<String, Object> uploadSponsor(MultipartFile file);
}

package com.api.manage.service.system;


import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadService {
    Map<String, Object> uploadAdvice(MultipartFile file);

    Map<String, Object> uploadArticle(MultipartFile file);

    Map<String, Object> uploadArticleDetail(MultipartFile file);

    Map<String, Object> uploadGambit(MultipartFile file);

    Map<String, Object> uploadVoteTitle(MultipartFile file);

    Map<String, Object> uploadVoteCandidate(MultipartFile file);

    Map<String, Object> uploadVoucher(MultipartFile file);

    Map<String, Object> uploadActivity(MultipartFile file);

    Map<String, Object> uploadAnnouncement(MultipartFile file);

    Map<String, Object> uploadAnnouncementDoc(MultipartFile file);

    Map<String, Object> uploadSponsor(MultipartFile file);

    Map<String, Object> uploadRepair(MultipartFile file);

    Map<String, Object> uploadOwnersCommittee(MultipartFile file);

    Map<String, Object> uploadGambitTheme(MultipartFile file);

    Map<String, Object> uploadDecorationNoticeDoc(MultipartFile file);

    Map<String, Object> uploadBusinessLicense(MultipartFile file);

    Map<String, Object> uploadQualificationCertificate(MultipartFile file);

    Map<String, Object> uploadDecorationDrawings(MultipartFile file);

    Map<String, Object> uploadDecorationApplicationForm(MultipartFile file);

    Map<String, Object> uploadDecorationCommitment(MultipartFile file);

    Map<String, Object> uploadInspectionFace(MultipartFile file);

    Map<String, Object> uploadInspectionSpace(MultipartFile file);

    Map<String, Object> uploadEstateExamine(MultipartFile file);

    Map<String, Object> uploadH5Visit(String fileStr);

    Map<String, Object> uploadQuestionnaireCoverPhoto(MultipartFile file);

    Map<String, Object> uploadFacilitiesCategory(MultipartFile file);

    Map<String, Object> uploadShoppingGoods(MultipartFile file);

    Map<String, Object> uploadShoppingCategory(MultipartFile file);

    Map<String, Object> uploadShoppingSupplier(MultipartFile file);

    Map<String, Object> uploadNews(MultipartFile file);

    Map<String, Object> uploadElectronicCommerce(MultipartFile file);

    Map<String, Object> uploadCommunityIntroduction(MultipartFile file);

    Map<String, Object> uploadContractDoc(MultipartFile file);

    Map<String, Object> uploadFacilitiesCheckPhoto(MultipartFile file);
}

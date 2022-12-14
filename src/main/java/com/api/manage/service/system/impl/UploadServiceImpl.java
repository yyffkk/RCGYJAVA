package com.api.manage.service.system.impl;

import com.api.manage.dao.butlerService.UserDecorationDao;
import com.api.manage.service.system.UploadService;
import com.api.model.businessManagement.SysUser;
import com.api.model.butlerService.UserDecorationDoc;
import com.api.util.BASE64DecodedMultipartFile;
import com.api.util.Base64StrToImage;
import com.api.util.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UploadServiceImpl implements UploadService {
    private static Map<String,Object> map = null;
    @Value("${prop.upload-advice}")
    private String UPLOAD_ADVICE;
    @Value("${prop.upload-article}")
    private String UPLOAD_ARTICLE;
    @Value("${prop.upload-article-detail}")
    private String UPLOAD_ARTICLE_DETAIL;
    @Value("${prop.upload-gambit}")
    private String UPLOAD_GAMBIT;
    @Value("${prop.upload-vote-title}")
    private String UPLOAD_VOTE_TITLE;
    @Value("${prop.upload-vote-candidate}")
    private String UPLOAD_VOTE_CANDIDATE;
    @Value("${prop.upload-voucher}")
    private String UPLOAD_VOUCHER;
    @Value("${prop.upload-activity}")
    private String UPLOAD_ACTIVITY;
    @Value("${prop.upload-announcement}")
    private String UPLOAD_ANNOUNCEMENT;
    @Value("${prop.upload-announcement-doc}")
    private String UPLOAD_ANNOUNCEMENT_DOC;
    @Value("${prop.upload-contract-doc}")
    private String UPLOAD_CONTRACT_DOC;
    @Value("${prop.upload-decoration-notice-doc}")
    private String UPLOAD_DECORATION_NOTICE_DOC;
    @Value("${prop.upload-sponsor}")
    private String UPLOAD_SPONSOR;
    @Value("${prop.upload-repair}")
    private String UPLOAD_REPAIR;
    @Value("${prop.upload-owners-committee}")
    private String UPLOAD_OWNERS_COMMITTEE;
    @Value("${prop.upload-gambit-theme}")
    private String UPLOAD_GAMBIT_THEME;
    @Value("${prop.upload-decoration-business-license}")
    private String UPLOAD_DECORATION_BUSINESS_LICENSE;
    @Value("${prop.upload-decoration-qualification-certificate}")
    private String UPLOAD_DECORATION_QUALIFICATION_CERTIFICATE;
    @Value("${prop.upload-decoration-decoration-drawings}")
    private String UPLOAD_DECORATION_DECORATION_DRAWINGS;
    @Value("${prop.upload-decoration-decoration-application-form}")
    private String UPLOAD_DECORATION_DECORATION_APPLICATION_FORM;
    @Value("${prop.upload-decoration-decoration-commitment}")
    private String UPLOAD_DECORATION_DECORATION_COMMITMENT;
    @Value("${prop.upload-butler-app-inspection-face}")
    private String UPLOAD_BUTLER_APP_INSPECTION_FACE;
    @Value("${prop.upload-butler-app-inspection-space}")
    private String UPLOAD_BUTLER_APP_INSPECTION_SPACE;
    @Value("${prop.upload-estate-examine}")
    private String UPLOAD_ESTATE_EXAMINE;
    @Value("${prop.upload-h5-visit}")
    private String UPLOAD_H5_VISIT;
    @Value("${prop.upload-questionnaire-cover-photo}")
    private String UPLOAD_QUESTIONNAIRE_COVER_PHOTO;
    @Value("${prop.upload-facilities-category}")
    private String UPLOAD_FACILITIES_CATEGORY;
    @Value("${prop.upload-shopping-goods}")
    private String UPLOAD_SHOPPING_GOODS;
    @Value("${prop.upload-shopping-category}")
    private String UPLOAD_SHOPPING_CATEGORY;
    @Value("${prop.upload-shopping-supplier}")
    private String UPLOAD_SHOPPING_SUPPLIER;
    @Value("${prop.upload-news}")
    private String UPLOAD_NEWS;
    @Value("${prop.upload-electronic-commerce}")
    private String UPLOAD_ELECTRONIC_COMMERCE;
    @Value("${prop.upload-community-introduction}")
    private String UPLOAD_COMMUNITY_INTRODUCTION;
    @Value("${prop.upload-facilities-check-photo}")
    private String UPLOAD_FACILITIES_CHECK_PHOTO;
    @Value("${prop.upload-regulation-management-doc}")
    private String UPLOAD_REGULATION_MANAGEMENT_DOC;
    @Value("${prop.upload-facilities-doc}")
    private String UPLOAD_FACILITIES_DOC;
    @Value("${prop.upload-lease-contract-pdf}")
    private String UPLOAD_LEASE_CONTRACT_PDF;
    @Value("${prop.upload-app-id-card-front}")
    private String UPLOAD_APP_ID_CARD_FRONT;
    @Value("${prop.upload-app-id-card-back}")
    private String UPLOAD_APP_ID_CARD_BACK;
    @Value("${prop.upload-lease-contract-signature-photo}")
    private String UPLOAD_LEASE_CONTRACT_SIGNATURE_PHONE;
    @Value("${prop.upload-lease-contract-valid-pdf}")
    private String UPLOAD_LEASE_CONTRACT_VALID_PDF;
    @Value("${prop.upload-app-clearing-single}")
    private String UPLOAD_APP_CLEARING_SINGLE;
    @Value("${prop.upload-material-record-invoice}")
    private String UPLOAD_MATERIAL_RECORD_INVOICE;
    @Value("${prop.upload-app-visit-id-card-front}")
    private String UPLOAD_APP_VISIT_ID_CARD_FRONT;
    @Value("${prop.upload-app-visit-id-card-back}")
    private String UPLOAD_APP_VISIT_ID_CARD_BACK;
    @Value("${prop.upload-app-housekeeping-service-submit-phone}")
    private String UPLOAD_APP_HOUSEKEEPING_SERVICE_SUBMIT_PHONE;
    @Value("${prop.upload-app-housekeeping-service-evaluation-phone}")
    private String UPLOAD_APP_HOUSEKEEPING_SERVICE_EVALUATION_PHONE;
    @Value("${prop.upload-housekeeping-service-handler-phone}")
    private String UPLOAD_HOUSEKEEPING_SERVICE_HANDLER_PHONE;
    @Value("${prop.upload-butler-app-engineering-repair}")
    private String UPLOAD_BUTLER_APP_ENGINEERING_REPAIR;
    @Value("${prop.upload-green-task-check-situation}")
    private String UPLOAD_GREEN_TASK_CHECK_SITUATION;
    @Value("${prop.upload-hygiene-task-check-situation}")
    private String UPLOAD_HYGIENE_TASK_CHECK_SITUATION;
    @Value("${prop.upload-butler-app-work???report}")
    private String UPLOAD_BUTLER_APP_WORK_REPORT;
    @Value("${prop.upload-butler-app-complete-maintenance}")
    private String UPLOAD_BUTLER_APP_COMPLETE_MAINTENANCE;
    @Value("${prop.upload-butler-app-acceptance}")
    private String UPLOAD_BUTLER_APP_ACCEPTANCE;
    @Value("${prop.upload-security-management-file-img}")
    private String UPLOAD_SECURITY_MANAGEMENT_FILE_IMG;
    @Value("${prop.upload-business-sys-user-resume}")
    private String UPLOAD_BUSINESS_SYS_USER_RESUME;
    @Value("${prop.upload-model-excel}")
    private String UPLOAD_MODEL_EXCEL;
    @Value("${prop.upload-house-type-description}")
    private String UPLOAD_HOUSE_TYPE_DESCRIPTION;
    @Value("${prop.upload-geography}")
    private String UPLOAD_GEOGRAPHY;
    @Value("${prop.upload-surrounding-enterprises}")
    private String UPLOAD_SURROUNDING_ENTERPRISES;
    @Value("${prop.upload-jcook-category}")
    private String UPLOAD_JCOOK_CATEGORY;
    @Value("${prop.upload-jcook-rotation}")
    private String UPLOAD_JCOOK_ROTATION;

    @Resource
    UserDecorationDao userDecorationDao;

    @Override
    public Map<String, Object> uploadAdvice(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ADVICE);
        return map;
    }

    @Override
    public Map<String, Object> uploadArticle(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ARTICLE);
        return map;
    }

    @Override
    public Map<String, Object> uploadArticleDetail(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ARTICLE_DETAIL);
        return map;
    }

    @Override
    public Map<String, Object> uploadGambit(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_GAMBIT);
        return map;
    }

    @Override
    public Map<String, Object> uploadVoteTitle(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_VOTE_TITLE);
        return map;
    }

    @Override
    public Map<String, Object> uploadVoteCandidate(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_VOTE_CANDIDATE);
        return map;
    }

    @Override
    public Map<String, Object> uploadVoucher(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_VOUCHER);
        return map;
    }

    @Override
    public Map<String, Object> uploadActivity(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ACTIVITY);
        return map;
    }

    @Override
    public Map<String, Object> uploadAnnouncement(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ANNOUNCEMENT);
        return map;
    }

    @Override
    public Map<String, Object> uploadSponsor(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_SPONSOR);
        return map;
    }

    @Override
    public Map<String, Object> uploadRepair(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_REPAIR);
        return map;
    }

    @Override
    public Map<String, Object> uploadOwnersCommittee(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_OWNERS_COMMITTEE);
        return map;
    }

    @Override
    public Map<String, Object> uploadGambitTheme(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_GAMBIT_THEME);
        return map;
    }

    @Override
    public Map<String, Object> uploadDecorationNoticeDoc(MultipartFile file) {
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.uploadDoc(file,UPLOAD_DECORATION_NOTICE_DOC);
            //???????????????????????????doc??????
            userDecorationDao.deleteAllDoc();
            //????????????????????????
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();
            //?????????????????????doc??????
            UserDecorationDoc userDecorationDoc = new UserDecorationDoc();
            userDecorationDoc.setName("????????????");
            userDecorationDoc.setUrl(url);
            userDecorationDoc.setCreateId(sysUser.getId());
            userDecorationDoc.setCreateDate(new Date());
            int insert = userDecorationDao.insertDoc(userDecorationDoc);
            if (insert <= 0){
                throw new RuntimeException("?????????????????????");
            }
        } catch (Exception e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            map.put("url","");
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("url",url);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> uploadBusinessLicense(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_DECORATION_BUSINESS_LICENSE);
        return map;
    }

    @Override
    public Map<String, Object> uploadQualificationCertificate(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_DECORATION_QUALIFICATION_CERTIFICATE);
        return map;
    }

    @Override
    public Map<String, Object> uploadDecorationDrawings(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_DECORATION_DECORATION_DRAWINGS);
        return map;
    }

    @Override
    public Map<String, Object> uploadDecorationApplicationForm(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_DECORATION_DECORATION_APPLICATION_FORM);
        return map;
    }

    @Override
    public Map<String, Object> uploadDecorationCommitment(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_DECORATION_DECORATION_COMMITMENT);
        return map;
    }

    @Override
    public Map<String, Object> uploadInspectionFace(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_BUTLER_APP_INSPECTION_FACE);
        return map;
    }

    @Override
    public Map<String, Object> uploadInspectionSpace(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_BUTLER_APP_INSPECTION_SPACE);
        return map;
    }

    @Override
    public Map<String, Object> uploadEstateExamine(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ESTATE_EXAMINE);
        return map;
    }

    @Override
    public Map<String, Object> uploadH5Visit(String fileStr) {
        BASE64DecodedMultipartFile base64DecodedMultipartFile = null;
        if(StringUtils.isNotBlank(fileStr)){
            base64DecodedMultipartFile =  (BASE64DecodedMultipartFile) Base64StrToImage.base64MutipartFile(fileStr);
        }
        Map<String, Object> map = upload(base64DecodedMultipartFile,UPLOAD_H5_VISIT);
        return map;
    }

    @Override
    public Map<String, Object> uploadQuestionnaireCoverPhoto(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_QUESTIONNAIRE_COVER_PHOTO);
        return map;
    }

    @Override
    public Map<String, Object> uploadFacilitiesCategory(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_FACILITIES_CATEGORY);
        return map;
    }

    @Override
    public Map<String, Object> uploadShoppingGoods(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_SHOPPING_GOODS);
        return map;
    }

    @Override
    public Map<String, Object> uploadShoppingCategory(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_SHOPPING_CATEGORY);
        return map;
    }

    @Override
    public Map<String, Object> uploadShoppingSupplier(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_SHOPPING_SUPPLIER);
        return map;
    }

    @Override
    public Map<String, Object> uploadNews(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_NEWS);
        return map;
    }

    @Override
    public Map<String, Object> uploadElectronicCommerce(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_ELECTRONIC_COMMERCE);
        return map;
    }

    @Override
    public Map<String, Object> uploadCommunityIntroduction(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_COMMUNITY_INTRODUCTION);
        return map;
    }

    @Override
    public Map<String, Object> uploadContractDoc(MultipartFile file) {
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.uploadDoc(file, UPLOAD_CONTRACT_DOC);
        } catch (Exception e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            map.put("url","");
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("url",url);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> uploadFacilitiesCheckPhoto(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_FACILITIES_CHECK_PHOTO);
        return map;
    }

    @Override
    public Map<String, Object> uploadRegulationManagementDoc(MultipartFile file) {
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.uploadDoc(file, UPLOAD_REGULATION_MANAGEMENT_DOC);
        } catch (Exception e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            map.put("url","");
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("url",url);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> uploadFacilitiesDoc(MultipartFile file) {
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.uploadDoc(file, UPLOAD_FACILITIES_DOC);
        } catch (Exception e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            map.put("url","");
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("url",url);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> uploadLeaseContractPdf(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_LEASE_CONTRACT_PDF);
        return map;
    }

    @Override
    public Map<String, Object> uploadAppIdCardFront(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_APP_ID_CARD_FRONT);
        return map;
    }

    @Override
    public Map<String, Object> uploadAppIdCardBack(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_APP_ID_CARD_BACK);
        return map;
    }

    @Override
    public Map<String, Object> uploadLeaseContractSignaturePhoto(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_LEASE_CONTRACT_SIGNATURE_PHONE);
        return map;
    }

    @Override
    public Map<String, Object> uploadLeaseContractValidPdf(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_LEASE_CONTRACT_VALID_PDF);
        return map;
    }

    @Override
    public Map<String, Object> uploadAppClearingSingle(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_APP_CLEARING_SINGLE);
        return map;
    }

    @Override
    public Map<String, Object> uploadMaterialRecordInvoice(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_MATERIAL_RECORD_INVOICE);
        return map;
    }

    @Override
    public Map<String, Object> uploadAppVisitIdCardFront(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_APP_VISIT_ID_CARD_FRONT);
        return map;
    }

    @Override
    public Map<String, Object> uploadAppVisitIdCardBack(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_APP_VISIT_ID_CARD_BACK);
        return map;
    }

    @Override
    public Map<String, Object> uploadAppHousekeepingServiceSubmitPhone(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_APP_HOUSEKEEPING_SERVICE_SUBMIT_PHONE);
        return map;
    }

    @Override
    public Map<String, Object> uploadAppHousekeepingServiceEvaluationPhone(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_APP_HOUSEKEEPING_SERVICE_EVALUATION_PHONE);
        return map;
    }

    @Override
    public Map<String, Object> uploadHousekeepingServiceHandlerPhone(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_HOUSEKEEPING_SERVICE_HANDLER_PHONE);
        return map;
    }

    @Override
    public Map<String, Object> uploadButlerAppEngineeringRepair(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_BUTLER_APP_ENGINEERING_REPAIR);
        return map;
    }

    @Override
    public Map<String, Object> uploadGreenTaskCheckSituation(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_GREEN_TASK_CHECK_SITUATION);
        return map;
    }

    @Override
    public Map<String, Object> uploadHygieneTaskCheckSituation(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_HYGIENE_TASK_CHECK_SITUATION);
        return map;
    }

    @Override
    public Map<String, Object> uploadButlerAppWorkReport(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_BUTLER_APP_WORK_REPORT);
        return map;
    }

    @Override
    public Map<String, Object> uploadButlerAppCompleteMaintenance(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_BUTLER_APP_COMPLETE_MAINTENANCE);
        return map;
    }

    @Override
    public Map<String, Object> uploadButlerAppAcceptance(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_BUTLER_APP_ACCEPTANCE);
        return map;
    }

    @Override
    public Map<String, Object> uploadSecurityManagementImg(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_SECURITY_MANAGEMENT_FILE_IMG);
        return map;
    }

    @Override
    public Map<String, Object> uploadBusinessSysUserResume(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_BUSINESS_SYS_USER_RESUME);
        return map;
    }

    @Override
    public Map<String, Object> uploadModelExcel(MultipartFile file) {
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            String name = file.getOriginalFilename();
            url = uploadUtil.uploadExcelFile(file, UPLOAD_MODEL_EXCEL,name);
        } catch (Exception e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            map.put("url","");
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("url",url);
        map.put("status",true);
        return map;
    }

    @Override
    public Map<String, Object> uploadHouseTypeDescriptionImg(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_HOUSE_TYPE_DESCRIPTION);
        return map;
    }

    @Override
    public Map<String, Object> uploadGeographyImg(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_GEOGRAPHY);
        return map;
    }

    @Override
    public Map<String, Object> uploadSurroundingEnterprisesImg(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_SURROUNDING_ENTERPRISES);
        return map;
    }

    @Override
    public Map<String, Object> uploadJcookCategory(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_JCOOK_CATEGORY);
        return map;
    }

    @Override
    public Map<String, Object> uploadJcookRotation(MultipartFile file) {
        Map<String, Object> map = upload(file,UPLOAD_JCOOK_ROTATION);
        return map;
    }

    @Override
    public Map<String, Object> uploadAnnouncementDoc(MultipartFile file) {
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.uploadDoc(file, UPLOAD_ANNOUNCEMENT_DOC);
        } catch (Exception e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            map.put("url","");
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("url",url);
        map.put("status",true);
        return map;
    }

    //????????????
    public Map<String,Object> upload(MultipartFile file,String path){
        map = new HashMap<>();
        String url = null;
        try {
            UploadUtil uploadUtil = new UploadUtil();
            url = uploadUtil.upload(file, path);
        } catch (Exception e) {
            //?????????????????????
            String message = e.getMessage();
            e.printStackTrace();
            map.put("message",message);
            map.put("url","");
            map.put("status",false);
            return map;
        }
        map.put("message","????????????");
        map.put("url",url);
        map.put("status",true);
        return map;
    }
}

package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyl
 * @since 2023-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("T_M00_CUSTOMER")
public class TM00Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("CUSTOMER_NO")
    private String customerNo;

    @TableField("NAME")
    private String name;

    @TableField("BRIEF_NAME")
    private String briefName;

    @TableField("ENG_NAME")
    private String engName;

    @TableField("ENG_BRIEF_NAME")
    private String engBriefName;

    @TableField("EXTERNAL_NAME")
    private String externalName;

    @TableField("CUSTOMER_NATURE")
    private Double customerNature;

    @TableField("CUSTOMER_TYPE")
    private Double customerType;

    @TableField("BUSINESS_ACCEPT_METHOD")
    private Double businessAcceptMethod;

    @TableField("LEGAL_NAME")
    private String legalName;

    @TableField("LEGAL_CARD_TYPE")
    private Double legalCardType;

    @TableField("LICENSE_NO")
    private String licenseNo;

    @TableField("MAIN_BUSINESS")
    private String mainBusiness;

    @TableField("REGISTER_CAPITAL")
    private Double registerCapital;

    @TableField("LICENSE_DEADLINE")
    private String licenseDeadline;

    @TableField("REGISTER_ADDRESS")
    private String registerAddress;

    @TableField("REGISTER_ZIPCODE")
    private String registerZipcode;

    @TableField("TAX_NO")
    private String taxNo;

    @TableField("TAX_MATURITY_DATE")
    private String taxMaturityDate;

    @TableField("ORGANIZATION_NO")
    private String organizationNo;

    @TableField("ENTERPRISE_NATURE")
    private Double enterpriseNature;

    @TableField("TURNOVER_YEAR")
    private Double turnoverYear;

    @TableField("OPEN_DATE")
    private LocalDateTime openDate;

    @TableField("RISK_NUM")
    private Double riskNum;

    @TableField("MERCHANT_NO")
    private String merchantNo;

    @TableField("OFFICE_ADDRESS")
    private String officeAddress;

    @TableField("OFFICE_ZIPCODE")
    private String officeZipcode;

    @TableField("PROVINCE")
    private String province;

    @TableField("CITY")
    private String city;

    @TableField("COUNTY")
    private String county;

    @TableField("ROAD")
    private String road;

    @TableField("HOUSE_NUMBER")
    private String houseNumber;

    @TableField("ADDRESS_LAST")
    private String addressLast;

    @TableField("CONTACT_PERSON")
    private String contactPerson;

    @TableField("CONTACT_DEPT")
    private String contactDept;

    @TableField("CONTACT_FAX")
    private String contactFax;

    @TableField("CONTACT_EMAIL")
    private String contactEmail;

    @TableField("FINANCE_PERSON")
    private String financePerson;

    @TableField("FINANCE_FAX")
    private String financeFax;

    @TableField("FINANCE_EMAIL")
    private String financeEmail;

    @TableField("GUARANTEE_METHOD")
    private Double guaranteeMethod;

    @TableField("GUARANTEE_METHOD_DESC")
    private String guaranteeMethodDesc;

    @TableField("ADDING_CATEGORY")
    private Double addingCategory;

    @TableField("SERVICE_NATURE")
    private Double serviceNature;

    @TableField("CONNECT_MODE")
    private Double connectMode;

    @TableField("CONTRACTANT_NO")
    private String contractantNo;

    @TableField("PROFESSION_SERVICE_INST")
    private Double professionServiceInst;

    @TableField("FOREIGN_CARD")
    private String foreignCard;

    @TableField("OVER_AREA_FLAG")
    private Double overAreaFlag;

    @TableField("WITHDRAW_DATE")
    private LocalDateTime withdrawDate;

    @TableField("WITHDRAW_CATEGORY")
    private Double withdrawCategory;

    @TableField("WITHDRAWER")
    private Double withdrawer;

    @TableField("WITHDRAWER_NAME")
    private String withdrawerName;

    @TableField("DEVELOPING_METHOD")
    private Double developingMethod;

    @TableField("DEVELOPING_DEPT")
    private Double developingDept;

    @TableField("DEVELOPING_DEPT_NAME")
    private String developingDeptName;

    @TableField("DEVELOPING_PERSON")
    private Double developingPerson;

    @TableField("DEVELOPING_PERSON_NAME")
    private String developingPersonName;

    @TableField("DEVELOPING_SIDE")
    private String developingSide;

    @TableField("DEVELOPING_SIDE_SUB_NO")
    private String developingSideSubNo;

    @TableField("DEVELOPING_SIDE_SUB_NAME")
    private String developingSideSubName;

    @TableField("REMARK")
    private String remark;

    @TableField("MERCHANT_RIGHT")
    private Double merchantRight;

    @TableField("STATUS")
    private Double status;

    @TableField("CHECK_FLAG")
    private Double checkFlag;

    @TableField("CHECK_DATE")
    private LocalDateTime checkDate;

    @TableField("CHECK_DESC")
    private String checkDesc;

    @TableField("REFUSE_REASON")
    private String refuseReason;

    @TableField("APPROVER")
    private Double approver;

    @TableField("APPROVER_NAME")
    private String approverName;

    @TableField("LAST_SERVICE_RATE")
    private Double lastServiceRate;

    @TableField("LAST_REVIEW_DATE")
    private LocalDateTime lastReviewDate;

    @TableField("CLIENT_MANAGER")
    private Double clientManager;

    @TableField("CLIENT_MANAGER_NAME")
    private String clientManagerName;

    @TableField("BMS_ID")
    private String bmsId;

    @TableField("CREATER")
    private String creater;

    @TableField(value = "CREATE_DATE", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @TableField("LAST_MODIFIER")
    private String lastModifier;

    @TableField("LAST_MODIFY_DATE")
    private LocalDateTime lastModifyDate;

    @TableField("BRANCH")
    private String branch;

    @TableField("PROVINCE_BRANCH")
    private String provinceBranch;

    @TableField("IS_DELETE")
    private Double isDelete;

    @TableField("MCC_CODE")
    private String mccCode;

    @TableField("HEAD_QUARTERS_FLAG")
    private Double headQuartersFlag;

    @TableField("ASSOCIATE_GROUP")
    private String associateGroup;

    @TableField("LEGAL_DEADLINE")
    private String legalDeadline;

    @TableField("ORGANIZATION_DEADLINE")
    private String organizationDeadline;

    @TableField("REAL_CONTROL_PERSON")
    private String realControlPerson;

    @TableField("LIMIT_ADJUSTMENT")
    private String limitAdjustment;

    @TableField("IS_VISIT")
    private String isVisit;

    @TableField("LAST_VISIT_TASK_ID")
    private String lastVisitTaskId;

    @TableField("NETWORK_MERCHANT_TYPE")
    private String networkMerchantType;

    @TableField("ICP_NO")
    private String icpNo;

    @TableField("LICENSE_NO_CHECK_RESULT")
    private String licenseNoCheckResult;

    @TableField("ID_CHECK_RESULT")
    private String idCheckResult;

    @TableField("UNION_CREDIT_NO")
    private String unionCreditNo;

    @TableField("REGIST_NAME")
    private String registName;

    @TableField("CURRENCY")
    private String currency;

    @TableField("ENTERPRISE_RES_NAME")
    private String enterpriseResName;

    @TableField("ENTERPRISE_TYPE")
    private String enterpriseType;

    @TableField("OPERATE_STATUS")
    private String operateStatus;

    @TableField("CANCELLATION_DATE")
    private String cancellationDate;

    @TableField("INDUSTRY_CATEGARY")
    private String industryCategary;

    @TableField("REGISTRATION_AUTH")
    private String registrationAuth;

    @TableField("IS_UNITE_MERCHANT")
    private String isUniteMerchant;

    @TableField("QR_CODE")
    private String qrCode;

    @TableField("QR_CODE_DESC")
    private String qrCodeDesc;

    @TableField("FIELD_1")
    private String field1;

    @TableField("FIELD_2")
    private String field2;

    @TableField("FIELD_3")
    private String field3;

    @TableField("FIELD_4")
    private String field4;

    @TableField("FIELD_5")
    private String field5;

    @TableField("FIELD_6")
    private String field6;

    @TableField("FIELD_7")
    private String field7;

    @TableField("FIELD_8")
    private String field8;

    @TableField("FIELD_9")
    private String field9;

    @TableField("FIELD_10")
    private String field10;

    @TableField("REAL_CONTROL_CARD_TYPE")
    private Double realControlCardType;

    @TableField("REAL_CONTROL_DEADLINE")
    private String realControlDeadline;

    @TableField("REAL_CONTROL_ID_CHECK_RESULT")
    private String realControlIdCheckResult;

    @TableField("AUTHORIZE_PERSON")
    private String authorizePerson;

    @TableField("AUTHORIZE_CARD_TYPE")
    private Double authorizeCardType;

    @TableField("AUTHORIZE_DEADLINE")
    private String authorizeDeadline;

    @TableField("AUTHORIZE_ID_CHECK_RESULT")
    private String authorizeIdCheckResult;

    @TableField("PLATFORM_ID")
    private String platformId;

    @TableField("SOURCE")
    private String source;

    @TableField("CUSTOMER_CERT_TYPE")
    private String customerCertType;

    @TableField("SEX")
    private String sex;

    @TableField("NATIONALITY")
    private String nationality;

    @TableField("OCCUPATION")
    private String occupation;

    @TableField("FIELD_11")
    private String field11;

    @TableField("FIELD_12")
    private String field12;

    @TableField("FIELD_13")
    private String field13;

    @TableField("FIELD_14")
    private String field14;

    @TableField("FIELD_15")
    private String field15;

    @TableField("FIELD_16")
    private String field16;

    @TableField("FIELD_17")
    private String field17;

    @TableField("FIELD_18")
    private String field18;

    @TableField("FIELD_19")
    private String field19;

    @TableField("FIELD_20")
    private String field20;

    @TableField("FIELD_21")
    private String field21;

    @TableField("FIELD_22")
    private String field22;

    @TableField("FIELD_23")
    private String field23;

    @TableField("FIELD_24")
    private String field24;

    @TableField("FIELD_25")
    private String field25;

    @TableField("URL")
    private String url;

    @TableField("SERVER_IP")
    private String serverIp;

    @TableField("IS_TRADITIONAL_MER")
    private String isTraditionalMer;

    @TableField("CONTACT_TEL_ENC")
    private String contactTelEnc;

    @TableField("LEGAL_CARD_NO_ENC")
    private String legalCardNoEnc;

    @TableField("CONTACT_MOBILE_ENC")
    private String contactMobileEnc;

    @TableField("REAL_CONTROL_CARD_NO_ENC")
    private String realControlCardNoEnc;

    @TableField("FINANCE_TEL_ENC")
    private String financeTelEnc;

    @TableField("AUTHORIZE_CARD_NO_ENC")
    private String authorizeCardNoEnc;

    @TableField("FINANCE_MOBILE_ENC")
    private String financeMobileEnc;

    @TableField("AUTHORIZE_MOBILE_ENC")
    private String authorizeMobileEnc;

    @TableField("LEGAL_TEL_ENC")
    private String legalTelEnc;

    @TableField("LEGAL_MOBILE_ENC")
    private String legalMobileEnc;

    @TableField("LEGAL_NAME_ENC")
    private String legalNameEnc;

    @TableField("CONTACT_FAX_ENC")
    private String contactFaxEnc;

    @TableField("CONTACT_EMAIL_ENC")
    private String contactEmailEnc;

    @TableField("FINANCE_FAX_ENC")
    private String financeFaxEnc;

    @TableField("FINANCE_EMAIL_ENC")
    private String financeEmailEnc;

    @TableField("CONTACT_PERSON_ENC")
    private String contactPersonEnc;

    @TableField("FINANCE_PERSON_ENC")
    private String financePersonEnc;

    @TableField("ENTERPRISE_RES_NAME_ENC")
    private String enterpriseResNameEnc;

    @TableField("REAL_CONTROL_PERSON_ENC")
    private String realControlPersonEnc;

    @TableField("AUTHORIZE_PERSON_ENC")
    private String authorizePersonEnc;

    @TableField("REGISTER_ADDRESS_ENC")
    private String registerAddressEnc;

    @TableField("OFFICE_ADDRESS_ENC")
    private String officeAddressEnc;

    @TableField("HOUSE_NUMBER_ENC")
    private String houseNumberEnc;

    @TableField("ADDRESS_LAST_ENC")
    private String addressLastEnc;

    @TableField("SERVER_IP_ENC")
    private String serverIpEnc;

    @TableField("IDX_LEGAL_NAME")
    private String idxLegalName;

    @TableField("IDX_CONTACT_FAX")
    private String idxContactFax;

    @TableField("IDX_CONTACT_EMAIL")
    private String idxContactEmail;

    @TableField("IDX_FINANCE_FAX")
    private String idxFinanceFax;

    @TableField("IDX_FINANCE_EMAIL")
    private String idxFinanceEmail;

    @TableField("IDX_REGISTER_ADDRESS")
    private String idxRegisterAddress;

    @TableField("IDX_OFFICE_ADDRESS")
    private String idxOfficeAddress;

    @TableField("IDX_HOUSE_NUMBER")
    private String idxHouseNumber;

    @TableField("IDX_ADDRESS_LAST")
    private String idxAddressLast;

    @TableField("IDX_SERVER_IP")
    private String idxServerIp;

    @TableField("IDX_CONTACT_PERSON")
    private String idxContactPerson;

    @TableField("IDX_FINANCE_PERSON")
    private String idxFinancePerson;

    @TableField("IDX_ENTERPRISE_RES_NAME")
    private String idxEnterpriseResName;

    @TableField("IDX_REAL_CONTROL_PERSON")
    private String idxRealControlPerson;

    @TableField("IDX_AUTHORIZE_PERSON")
    private String idxAuthorizePerson;

    @TableField("MERCHANT_SERVICE_TYPE")
    private String merchantServiceType;

    @TableField("IS_NEED_UK_CHECK")
    private String isNeedUkCheck;

    @TableField("CONTACT_TEL_GENC")
    private String contactTelGenc;

    @TableField("LEGAL_CARD_NO_GENC")
    private String legalCardNoGenc;

    @TableField("CONTACT_MOBILE_GENC")
    private String contactMobileGenc;

    @TableField("REAL_CONTROL_CARD_NO_GENC")
    private String realControlCardNoGenc;

    @TableField("FINANCE_TEL_GENC")
    private String financeTelGenc;

    @TableField("AUTHORIZE_CARD_NO_GENC")
    private String authorizeCardNoGenc;

    @TableField("FINANCE_MOBILE_GENC")
    private String financeMobileGenc;

    @TableField("AUTHORIZE_MOBILE_GENC")
    private String authorizeMobileGenc;

    @TableField("LEGAL_TEL_GENC")
    private String legalTelGenc;

    @TableField("LEGAL_MOBILE_GENC")
    private String legalMobileGenc;

    @TableField("IDX_CONTACT_TEL")
    private String idxContactTel;

    @TableField("IDX_LEGAL_CARD_NO")
    private String idxLegalCardNo;

    @TableField("IDX_CONTACT_MOBILE")
    private String idxContactMobile;

    @TableField("IDX_REAL_CONTROL_CARD_NO")
    private String idxRealControlCardNo;

    @TableField("IDX_FINANCE_TEL")
    private String idxFinanceTel;

    @TableField("IDX_AUTHORIZE_CARD_NO")
    private String idxAuthorizeCardNo;

    @TableField("IDX_FINANCE_MOBILE")
    private String idxFinanceMobile;

    @TableField("IDX_AUTHORIZE_MOBILE")
    private String idxAuthorizeMobile;

    @TableField("IDX_LEGAL_TEL")
    private String idxLegalTel;

    @TableField("IDX_LEGAL_MOBILE")
    private String idxLegalMobile;

    @TableField("CONTACT_TEL")
    private String contactTel;

    @TableField("CONTACT_MOBILE")
    private String contactMobile;

    @TableField("FINANCE_TEL")
    private String financeTel;

    @TableField("FINANCE_MOBILE")
    private String financeMobile;

    @TableField("AUTHORIZE_MOBILE")
    private String authorizeMobile;

    @TableField("LEGAL_TEL")
    private String legalTel;

    /**
     * ??????
     */
    @TableField("LEGAL_MOBILE")
    private String legalMobile;

    @TableField("LEGAL_CARD_NO")
    private String legalCardNo;

    @TableField("REAL_CONTROL_CARD_NO")
    private String realControlCardNo;

    @TableField("AUTHORIZE_CARD_NO")
    private String authorizeCardNo;


}

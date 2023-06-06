package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyl
 * @since 2023-06-06
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("T_M00_CUSTOMER")
public class M00Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    private String customerNo;

    private String name;

    private String briefName;

    private String engName;

    private String engBriefName;

    private String externalName;

    private Long customerNature;

    private Long customerType;

    private Long businessAcceptMethod;

    private String legalName;

    private Long legalCardType;

    private String licenseNo;

    private String mainBusiness;

    private BigDecimal registerCapital;

    private String licenseDeadline;

    private String registerAddress;

    private String registerZipcode;

    private String taxNo;

    private String taxMaturityDate;

    private String organizationNo;

    private Long enterpriseNature;

    private Long turnoverYear;

    private LocalDateTime openDate;

    private Long riskNum;

    private String merchantNo;

    private String officeAddress;

    private String officeZipcode;

    private String province;

    private String city;

    private String county;

    private String road;

    private String houseNumber;

    private String addressLast;

    private String contactPerson;

    private String contactDept;

    private String contactFax;

    private String contactEmail;

    private String financePerson;

    private String financeFax;

    private String financeEmail;

    private Long guaranteeMethod;

    private String guaranteeMethodDesc;

    private Long addingCategory;

    private Long serviceNature;

    private Long connectMode;

    private String contractantNo;

    private Long professionServiceInst;

    private String foreignCard;

    private Long overAreaFlag;

    private LocalDateTime withdrawDate;

    private Long withdrawCategory;

    private Long withdrawer;

    private String withdrawerName;

    private Long developingMethod;

    private Long developingDept;

    private String developingDeptName;

    private Long developingPerson;

    private String developingPersonName;

    private String developingSide;

    private String developingSideSubNo;

    private String developingSideSubName;

    private String remark;

    private Long merchantRight;

    private Long status;

    private Long checkFlag;

    private LocalDateTime checkDate;

    private String checkDesc;

    private String refuseReason;

    private Long approver;

    private String approverName;

    private Long lastServiceRate;

    private LocalDateTime lastReviewDate;

    private Long clientManager;

    private String clientManagerName;

    private String bmsId;

    private String creater;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    private String lastModifier;

    private LocalDateTime lastModifyDate;

    private String branch;

    private String provinceBranch;

    @TableField(fill = FieldFill.INSERT)
    private Long isDelete;

    private String mccCode;

    private Long headQuartersFlag;

    private String associateGroup;

    private String legalDeadline;

    private String organizationDeadline;

    private String realControlPerson;

    private String limitAdjustment;

    private String isVisit;

    private String lastVisitTaskId;

    private String networkMerchantType;

    private String icpNo;

    private String licenseNoCheckResult;

    private String idCheckResult;

    private String unionCreditNo;

    private String registName;

    private String currency;

    private String enterpriseResName;

    private String enterpriseType;

    private String operateStatus;

    private String cancellationDate;

    private String industryCategary;

    private String registrationAuth;

    private String isUniteMerchant;

    private String qrCode;

    private String qrCodeDesc;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    private String field6;

    private String field7;

    private String field8;

    private String field9;

    private String field10;

    private Long realControlCardType;

    private String realControlDeadline;

    private String realControlIdCheckResult;

    private String authorizePerson;

    private Long authorizeCardType;

    private String authorizeDeadline;

    private String authorizeIdCheckResult;

    private String platformId;

    private String source;

    private String customerCertType;

    private String sex;

    private String nationality;

    private String occupation;

    private String field11;

    private String field12;

    private String field13;

    private String field14;

    private String field15;

    private String field16;

    private String field17;

    private String field18;

    private String field19;

    private String field20;

    private String field21;

    private String field22;

    private String field23;

    private String field24;

    private String field25;

    private String url;

    private String serverIp;

    private String isTraditionalMer;

    private String contactTelEnc;

    private String legalCardNoEnc;

    private String contactMobileEnc;

    private String realControlCardNoEnc;

    private String financeTelEnc;

    private String authorizeCardNoEnc;

    private String financeMobileEnc;

    private String authorizeMobileEnc;

    private String legalTelEnc;

    private String legalMobileEnc;

    private String legalNameEnc;

    private String contactFaxEnc;

    private String contactEmailEnc;

    private String financeFaxEnc;

    private String financeEmailEnc;

    private String contactPersonEnc;

    private String financePersonEnc;

    private String enterpriseResNameEnc;

    private String realControlPersonEnc;

    private String authorizePersonEnc;

    private String registerAddressEnc;

    private String officeAddressEnc;

    private String houseNumberEnc;

    private String addressLastEnc;

    private String serverIpEnc;

    private String idxLegalName;

    private String idxContactFax;

    private String idxContactEmail;

    private String idxFinanceFax;

    private String idxFinanceEmail;

    private String idxRegisterAddress;

    private String idxOfficeAddress;

    private String idxHouseNumber;

    private String idxAddressLast;

    private String idxServerIp;

    private String idxContactPerson;

    private String idxFinancePerson;

    private String idxEnterpriseResName;

    private String idxRealControlPerson;

    private String idxAuthorizePerson;

    private String merchantServiceType;

    private String isNeedUkCheck;

    private String contactTelGenc;

    private String legalCardNoGenc;

    private String contactMobileGenc;

    private String realControlCardNoGenc;

    private String financeTelGenc;

    private String authorizeCardNoGenc;

    private String financeMobileGenc;

    private String authorizeMobileGenc;

    private String legalTelGenc;

    private String legalMobileGenc;

    private String idxContactTel;

    private String idxLegalCardNo;

    private String idxContactMobile;

    private String idxRealControlCardNo;

    private String idxFinanceTel;

    private String idxAuthorizeCardNo;

    private String idxFinanceMobile;

    private String idxAuthorizeMobile;

    private String idxLegalTel;

    private String idxLegalMobile;

    private String contactTel;

    private String contactMobile;

    private String financeTel;

    private String financeMobile;

    private String authorizeMobile;

    private String legalTel;

    private String legalMobile;

    private String legalCardNo;

    private String realControlCardNo;

    private String authorizeCardNo;
}

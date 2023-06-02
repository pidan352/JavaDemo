package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author lyl
 * @since 2023-05-30
 */
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@TableName("T_M04_MER_MULTI_APP")
public class TM04MerMultiApp implements Serializable {

    private static final long serialVersionUID = 1L;



    @TableField("ID")
    private String id;

    @TableField("CUSTOMER_ID")
    private String customerId;

    @TableField("IS_MAIN")
    private Double isMain;

    @TableField("PROJECT_NAME")
    private String projectName;

    @TableField("PROJECT_SUB_CATEGORIES")
    private String projectSubCategories;

    @TableField("REGISTER_WAY")
    private Double registerWay;

    @TableField("STATUS")
    private Double status;

    @TableField("MCC_CODE")
    private String mccCode;

    @TableField("MERCHANT_NO")
    private String merchantNo;

    @TableField("TRA_FRONT_PLATFORM_NO")
    private String traFrontPlatformNo;

    @TableField("TRA_ACCEPT_CHANNEL_NO")
    private String traAcceptChannelNo;

    @TableField("SETTLEMENT_NO")
    private String settlementNo;

    @TableField("HEAD_QUARTERS_FLAG")
    private Double headQuartersFlag;

    @TableField("IS_TRADE_PROCESS")
    private Double isTradeProcess;

    @TableField("IS_SETTLEMENT")
    private Double isSettlement;

    @TableField("NET_IDENTIFIER")
    private String netIdentifier;

    @TableField("OLD_MERCHANT_NO")
    private String oldMerchantNo;

    @TableField("ACQUIRER_NO")
    private String acquirerNo;

    @TableField("ACQUIRER_SUB_NO")
    private String acquirerSubNo;

    @TableField("ACQUIRER_SUB_NAME")
    private String acquirerSubName;

    @TableField("ACQUIRER_MERCHANT_NO")
    private String acquirerMerchantNo;

    @TableField("DEALING_TYPES")
    private String dealingTypes;

    @TableField("KEY_INDEX")
    private String keyIndex;

    @TableField("TELPHONE1")
    private String telphone1;

    @TableField("TELPHONE2")
    private String telphone2;

    @TableField("TELPHONE3")
    private String telphone3;

    @TableField("MAINTAIN_TEL")
    private String maintainTel;

    @TableField("APP_BEGIN_DATE")
    private LocalDateTime appBeginDate;

    @TableField("APP_END_DATE")
    private LocalDateTime appEndDate;

    @TableField("CHECK_FLAG")
    private Double checkFlag;

    @TableField("REFUSE_REASON")
    private String refuseReason;

    @TableField("PASS_TYPE")
    private String passType;

    @TableField("DEVELOPING_DEPT")
    private Double developingDept;

    @TableField("DEVELOPING_DEPT_NAME")
    private String developingDeptName;

    @TableField("DEVELOPING_PERSON")
    private Double developingPerson;

    @TableField("DEVELOPING_PERSON_NAME")
    private String developingPersonName;

    @TableField("CUSTOMER_MANAGER")
    private Double customerManager;

    @TableField("CUSTOMER_MANAGER_NAME")
    private String customerManagerName;

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
    private String isDelete;

    @TableField("CHECK_DATE")
    private LocalDateTime checkDate;

    @TableField("APP_CATEGORY")
    private Double appCategory;

    @TableField("BUSINESS_CATEGORY")
    private String businessCategory;

    @TableField("SUPPORT_CARD")
    private String supportCard;

    @TableField("APP_NO")
    private Double appNo;

    @TableField("SUPPORT_CARDTYPE")
    private String supportCardtype;

    @TableField("FEE_TYPE")
    private String feeType;

    @TableField("FEE_LEVEL")
    private String feeLevel;

    @TableField("PAY_COMMENTS")
    private String payComments;

    @TableField("CAPITALMERNO")
    private String capitalmerno;

    @TableField("ACQUIRERINSTNO")
    private String acquirerinstno;

    @TableField("OPSFLAG")
    private String opsflag;

    @TableField("CLASSICFLAG")
    private String classicflag;

    @TableField("IS_ALLOW_DOWN")
    private String isAllowDown;

    @TableField("UNION_REG_CODE")
    private String unionRegCode;

    @TableField("IS_WHITE_FLAG")
    private String isWhiteFlag;

    @TableField("DEBIT_CREDIT_FLAG")
    private Double debitCreditFlag;

    @TableField("RETURN_FLAG")
    private Double returnFlag;

    @TableField("RETURN_RATE")
    private String returnRate;

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

    @TableField("IS_OUTRULE")
    private String isOutrule;

    @TableField("OUTRULE_REASON")
    private String outruleReason;

    @TableField("APPLY_FREE_SIGN_FREE_PASSWORD")
    private String applyFreeSignFreePassword;

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

    /**
     * POS?????????
     */
    @TableField("TELPHONE1_ENC")
    private String telphone1Enc;

    /**
     * POS?????????
     */
    @TableField("TELPHONE2_ENC")
    private String telphone2Enc;

    /**
     * POS?????????
     */
    @TableField("TELPHONE3_ENC")
    private String telphone3Enc;

    /**
     * ??????????
     */
    @TableField("MAINTAIN_TEL_ENC")
    private String maintainTelEnc;

    /**
     * ????1:???????2:???????3:???????4:??????
     */
    @TableField("RISK_RANK")
    private String riskRank;

    /**
     * POS???????(????????)
     */
    @TableField("TELPHONE1_BGENC")
    private String telphone1Bgenc;

    /**
     * POS???????(????????)
     */
    @TableField("TELPHONE2_BGENC")
    private String telphone2Bgenc;

    /**
     * POS???????(????????)
     */
    @TableField("TELPHONE3_BGENC")
    private String telphone3Bgenc;

    /**
     * ????????(????????)
     */
    @TableField("MAINTAIN_TEL_BGENC")
    private String maintainTelBgenc;


}

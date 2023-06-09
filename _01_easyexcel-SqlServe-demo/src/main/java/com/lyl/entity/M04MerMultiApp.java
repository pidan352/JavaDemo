package com.lyl.entity;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("T_M04_MER_MULTI_APP")
@ExcelIgnoreUnannotated
@ToString
public class M04MerMultiApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty("数据库ID")
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    @ExcelProperty("客户ID")
    @TableField("CUSTOMER_ID")
    private String customerId;

    @ExcelProperty("IsMain")
    @TableField("IS_MAIN")
    private Long isMain;

    @TableField(value = "PROJECT_NAME")
    private String projectName;

    @TableField("PROJECT_SUB_CATEGORIES")
    private String projectSubCategories;

    @ExcelProperty("注册方式")
    @TableField("REGISTER_WAY")
    private Long registerWay;

    @ExcelProperty("状态")
    @TableField("STATUS")
    private Long status;

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

    @ExcelProperty("首季度标识")
    @TableField("HEAD_QUARTERS_FLAG")
    private Long headQuartersFlag;

    @ExcelProperty("是否为贸易程序")
    @TableField("IS_TRADE_PROCESS")
    private Long isTradeProcess;

    @ExcelProperty("是否结算")
    @TableField("IS_SETTLEMENT")
    private Long isSettlement;

    @TableField("NET_IDENTIFIER")
    private String netIdentifier;

    @TableField("OLD_MERCHANT_NO")
    private String oldMerchantNo;

    @ExcelProperty("收单行编号")
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
    private Long checkFlag;

    @TableField("REFUSE_REASON")
    private String refuseReason;

    @TableField("PASS_TYPE")
    private String passType;

    @TableField("DEVELOPING_DEPT")
    private Long developingDept;

    @TableField("DEVELOPING_DEPT_NAME")
    private String developingDeptName;

    @TableField("DEVELOPING_PERSON")
    private Long developingPerson;

    @TableField("DEVELOPING_PERSON_NAME")
    private String developingPersonName;

    @TableField("CUSTOMER_MANAGER")
    private Long customerManager;

    @TableField("CUSTOMER_MANAGER_NAME")
    private String customerManagerName;

    @TableField("BMS_ID")
    private String bmsId;

    @ExcelProperty("创建者")
    @TableField("CREATER")
    private String creater;

    @ExcelProperty("创建日期")
    @TableField(value = "CREATE_DATE", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @ExcelProperty("上次修改者")
    @TableField("LAST_MODIFIER")
    private String lastModifier;

    @ExcelProperty("上次修改时间")
    @TableField("LAST_MODIFY_DATE")
    private LocalDateTime lastModifyDate;

    @ExcelProperty("分支机构")
    @TableField("BRANCH")
    private String branch;

    @ExcelProperty("省分支")
    @TableField("PROVINCE_BRANCH")
    private String provinceBranch;

    @ExcelProperty("逻辑删除")
    @TableField(value = "IS_DELETE", fill = FieldFill.INSERT)
    private String isDelete;

    @TableField("CHECK_DATE")
    private LocalDateTime checkDate;

    @ExcelProperty("应用程序类别")
    @TableField("APP_CATEGORY")
    private Long appCategory;

    @TableField("BUSINESS_CATEGORY")
    private String businessCategory;

    @TableField("SUPPORT_CARD")
    private String supportCard;

    @ExcelProperty("应用程序编号")
    @TableField("APP_NO")
    private Long appNo;

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
    private Long debitCreditFlag;

    @TableField("RETURN_FLAG")
    private Long returnFlag;

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

    @TableField("TELPHONE1_ENC")
    private String telphone1Enc;

    @TableField("TELPHONE2_ENC")
    private String telphone2Enc;

    @TableField("TELPHONE3_ENC")
    private String telphone3Enc;

    @TableField("MAINTAIN_TEL_ENC")
    private String maintainTelEnc;

    @TableField("RISK_RANK")
    private String riskRank;

    @TableField("TELPHONE1_BGENC")
    private String telphone1Bgenc;

    @TableField("TELPHONE2_BGENC")
    private String telphone2Bgenc;

    @TableField("TELPHONE3_BGENC")
    private String telphone3Bgenc;

    @TableField("MAINTAIN_TEL_BGENC")
    private String maintainTelBgenc;
}

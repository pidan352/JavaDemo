package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("T_M04_MER_MULTI_APP")
public class M04MerMultiApp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    private String customerId;

    private Long isMain;

    private String projectName;

    private String projectSubCategories;

    private Long registerWay;

    private Long status;

    private String mccCode;

    private String merchantNo;

    private String traFrontPlatformNo;

    private String traAcceptChannelNo;

    private String settlementNo;

    private Long headQuartersFlag;

    private Long isTradeProcess;

    private Long isSettlement;

    private String netIdentifier;

    private String oldMerchantNo;

    private String acquirerNo;

    private String acquirerSubNo;

    private String acquirerSubName;

    private String acquirerMerchantNo;

    private String dealingTypes;

    private String keyIndex;

    private String telphone1;

    private String telphone2;

    private String telphone3;

    private String maintainTel;

    private LocalDateTime appBeginDate;

    private LocalDateTime appEndDate;

    private Long checkFlag;

    private String refuseReason;

    private String passType;

    private Long developingDept;

    private String developingDeptName;

    private Long developingPerson;

    private String developingPersonName;

    private Long customerManager;

    private String customerManagerName;

    private String bmsId;

    private String creater;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    private String lastModifier;

    private LocalDateTime lastModifyDate;

    private String branch;

    private String provinceBranch;

    @TableField(fill = FieldFill.INSERT)
    private String isDelete;

    private LocalDateTime checkDate;

    private Long appCategory;

    private String businessCategory;

    private String supportCard;

    private Long appNo;

    private String supportCardtype;

    private String feeType;

    private String feeLevel;

    private String payComments;

    private String capitalmerno;

    private String acquirerinstno;

    private String opsflag;

    private String classicflag;

    private String isAllowDown;

    private String unionRegCode;

    private String isWhiteFlag;

    private Long debitCreditFlag;

    private Long returnFlag;

    private String returnRate;

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

    private String isOutrule;

    private String outruleReason;

    private String applyFreeSignFreePassword;

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

    private String telphone1Enc;

    private String telphone2Enc;

    private String telphone3Enc;

    private String maintainTelEnc;

    private String riskRank;

    private String telphone1Bgenc;

    private String telphone2Bgenc;

    private String telphone3Bgenc;

    private String maintainTelBgenc;
}

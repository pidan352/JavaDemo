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
@TableName("T_M10_MER_ACCOUNT")
public class TM10MerAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("CUSTOMER_ID")
    private String customerId;

    @TableField("ACCOUNT_TYPE")
    private Double accountType;

    @TableField("ORDER_NO")
    private Double orderNo;

    @TableField("BANK_NO")
    private String bankNo;

    @TableField("BANK_NAME")
    private String bankName;

    @TableField("ACCOUNT_NO")
    private String accountNo;

    @TableField("ACCOUNT_NAME")
    private String accountName;

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

    @TableField("DEPOSIT_BANK_NO")
    private String depositBankNo;

    @TableField("STATUS")
    private String status;

    @TableField("ACCOUNT_NATURE")
    private String accountNature;

    @TableField("IS_OUTRULE")
    private String isOutrule;

    @TableField("OUTRULE_REASON")
    private String outruleReason;

    @TableField("SPEC_FLAG")
    private String specFlag;

    @TableField("RESERVED_NUMBER")
    private String reservedNumber;

    @TableField("IS_HIT_BLACK")
    private String isHitBlack;

    @TableField("CURRENCY_TYPE")
    private String currencyType;

    /**
     * ??????
     */
    @TableField("ACCOUNT_NO_ENC")
    private String accountNoEnc;

    /**
     * ????(????????)
     */
    @TableField("ACCOUNT_NO_BGENC")
    private String accountNoBgenc;

    /**
     * ???????????
     */
    @TableField("RESERVED_NUMBER_BGENC")
    private String reservedNumberBgenc;


}

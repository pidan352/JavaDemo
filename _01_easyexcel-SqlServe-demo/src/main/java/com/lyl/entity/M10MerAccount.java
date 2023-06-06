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
@TableName("T_M10_MER_ACCOUNT")
public class M10MerAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    private String customerId;

    private Long accountType;

    private Long orderNo;

    private String bankNo;

    private String bankName;

    private String accountNo;

    private String accountName;

    private String creater;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    private String lastModifier;

    private LocalDateTime lastModifyDate;

    private String branch;

    private String provinceBranch;

    @TableField(fill = FieldFill.INSERT)
    private String isDelete;

    private String depositBankNo;

    private String status;

    private String accountNature;

    private String isOutrule;

    private String outruleReason;

    private String specFlag;

    private String reservedNumber;

    private String isHitBlack;

    private String currencyType;

    private String accountNoEnc;

    private String accountNoBgenc;

    private String reservedNumberBgenc;
}

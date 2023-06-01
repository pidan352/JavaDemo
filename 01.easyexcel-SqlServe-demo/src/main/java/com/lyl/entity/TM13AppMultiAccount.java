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
@TableName("T_M13_APP_MULTI_ACCOUNT")
public class TM13AppMultiAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableField("CUSTOMER_ID")
    private String customerId;

    @TableField("MULTI_APP_ID")
    private String multiAppId;

    @TableField("ACCOUNT_ID")
    private String accountId;

    @TableField("CARD_ATTR")
    private Double cardAttr;

    @TableField("ISSUE_INST_NO")
    private String issueInstNo;

    @TableField("PRIORITY")
    private Double priority;

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


}

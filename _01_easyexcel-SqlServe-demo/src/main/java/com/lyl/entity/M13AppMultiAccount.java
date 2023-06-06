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
@TableName("T_M13_APP_MULTI_ACCOUNT")
public class M13AppMultiAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("CUSTOMER_ID")
    private String customerId;

    @TableField("MULTI_APP_ID")
    private String multiAppId;

    @TableField("ACCOUNT_ID")
    private String accountId;

    @TableField("CARD_ATTR")
    private Long cardAttr;

    @TableField("ISSUE_INST_NO")
    private String issueInstNo;

    @TableField("PRIORITY")
    private Long priority;

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

    @TableField(value = "IS_DELETE", fill = FieldFill.INSERT)
    private String isDelete;
}

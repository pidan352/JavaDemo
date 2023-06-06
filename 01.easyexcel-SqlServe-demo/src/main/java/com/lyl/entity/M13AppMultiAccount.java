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

    private String customerId;

    private String multiAppId;

    private String accountId;

    private Long cardAttr;

    private String issueInstNo;

    private Long priority;

    private String creater;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    private String lastModifier;

    private LocalDateTime lastModifyDate;

    private String branch;

    private String provinceBranch;

    @TableField(fill = FieldFill.INSERT)
    private String isDelete;
}

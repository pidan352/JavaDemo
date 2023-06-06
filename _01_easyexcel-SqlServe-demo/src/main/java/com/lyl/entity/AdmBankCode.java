package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("adm_bank_code")
public class AdmBankCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("bank_code")
    private String bankCode;

    @TableField("old_code")
    private String oldCode;

    @TableField("bank_sign")
    private String bankSign;

    @TableField("bank_name")
    private String bankName;
}

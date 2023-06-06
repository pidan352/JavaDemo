package com.lyl.entity;

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

    private String bankCode;

    private String oldCode;

    private String bankSign;

    private String bankName;
}

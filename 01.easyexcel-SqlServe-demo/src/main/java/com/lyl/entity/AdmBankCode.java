package com.lyl.entity;

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
public class AdmBankCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bankCode;

    private String oldCode;

    private String bankSign;

    private String bankName;


}

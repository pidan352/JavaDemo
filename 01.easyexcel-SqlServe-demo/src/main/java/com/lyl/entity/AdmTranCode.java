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
public class AdmTranCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private String tranCode;

    private String requstCode;

    private String responseCode;

    private String tranType3;

    private String servicePoint25;

    private Integer settFlag;

    private String isNeedSett;

    private String remark;

    private String duizhRemark;


}

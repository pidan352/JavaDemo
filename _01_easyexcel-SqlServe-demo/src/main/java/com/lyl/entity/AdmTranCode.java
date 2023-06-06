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
@TableName("adm_tran_code")
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

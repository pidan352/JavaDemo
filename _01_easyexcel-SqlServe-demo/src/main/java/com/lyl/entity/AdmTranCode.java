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
@TableName("adm_tran_code")
public class AdmTranCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("tran_code")
    private String tranCode;

    @TableField("requst_code")
    private String requstCode;

    @TableField("response_code")
    private String responseCode;

    @TableField("tran_type_3")
    private String tranType3;

    @TableField("service_point_25")
    private String servicePoint25;

    @TableField("sett_flag")
    private Integer settFlag;

    @TableField("is_need_sett")
    private String isNeedSett;

    @TableField("remark")
    private String remark;

    @TableField("duizh_remark")
    private String duizhRemark;
}

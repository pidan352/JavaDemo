package com.lyl.entity;

import java.math.BigDecimal;
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
public class Translog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ssn;

    private String termSsn;

    private String txAcc;

    private String merCode;

    private String term;

    private String tranCode;

    private String tranCurr;

    private String settCurr;

    private String cbBank;

    private String actDate;

    private String actTime;

    private String postDate;

    private BigDecimal tranAmt;

    private BigDecimal nTranAmt;

    private BigDecimal hsAmt;

    private BigDecimal hsComm;

    private Integer fcardtype;

    private BigDecimal fcomma;

    private Integer feps;

    private String cardNo;

    private String jsCode;

    @TableField("servicePointInserttype")
    private String servicepointinserttype;

    private String termAbility;

    @TableField("ICcardConditionCode")
    private String iccardconditioncode;

    private String typeid;

    private String indexNo;


}

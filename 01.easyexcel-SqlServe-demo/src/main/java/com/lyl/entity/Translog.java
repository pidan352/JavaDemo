package com.lyl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

    private Byte fcardtype;

    private BigDecimal fcomma;

    private Byte feps;

    private String cardNo;

    private String jsCode;

    private String servicePointInserttype;

    private String termAbility;

    private String iCcardConditionCode;

    private String typeid;

    private String indexNo;
}

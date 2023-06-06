package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("translog")
public class Translog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ssn")
    private String ssn;

    @TableField("term_ssn")
    private String termSsn;

    @TableField("tx_acc")
    private String txAcc;

    @TableField("mer_code")
    private String merCode;

    @TableField("term")
    private String term;

    @TableField("tran_code")
    private String tranCode;

    @TableField("tran_curr")
    private String tranCurr;

    @TableField("sett_curr")
    private String settCurr;

    @TableField("cb_bank")
    private String cbBank;

    @TableField("act_date")
    private String actDate;

    @TableField("act_time")
    private String actTime;

    @TableField("post_date")
    private String postDate;

    @TableField("tran_amt")
    private BigDecimal tranAmt;

    @TableField("n_tran_amt")
    private BigDecimal nTranAmt;

    @TableField("hs_amt")
    private BigDecimal hsAmt;

    @TableField("hs_comm")
    private BigDecimal hsComm;

    @TableField("fcardtype")
    private Byte fcardtype;

    @TableField("fcomma")
    private BigDecimal fcomma;

    @TableField("feps")
    private Byte feps;

    @TableField("card_no")
    private String cardNo;

    @TableField("js_code")
    private String jsCode;

    @TableField("servicePointInserttype")
    private String servicePointInserttype;

    @TableField("term_ability")
    private String termAbility;

    @TableField("ICcardConditionCode")
    private String iCcardConditionCode;

    @TableField("typeid")
    private String typeid;

    @TableField("index_no")
    private String indexNo;
}

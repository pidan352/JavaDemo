package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
@TableName("T_C10_APP_CONFIG")
public class TC10AppConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private Double id;

    @TableField("BRANCH")
    private String branch;

    @TableField("NAME")
    private String name;

    @TableField("APP_NO")
    private Double appNo;

    @TableField("ENABLE")
    private Double enable;

    @TableField("IMPORT_KEY")
    private Double importKey;

    @TableField("CREATER")
    private String creater;

    @TableField(value = "CREATE_DATE", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    @TableField("APP_CATEGORY")
    private Double appCategory;

    @TableField("DIRECT_AUTO_CUPS_PUSH")
    private Double directAutoCupsPush;

    @TableField("INDIRECT_AUTO_CUPS_PUSH")
    private Double indirectAutoCupsPush;

    @TableField("IS_ATM")
    private Double isAtm;


}

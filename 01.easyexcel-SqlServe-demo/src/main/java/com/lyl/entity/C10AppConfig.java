package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("T_C10_APP_CONFIG")
public class C10AppConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private Long id;

    @TableId(value = "BRANCH", type = IdType.ASSIGN_UUID)
    private String branch;

    private String name;

    private Long appNo;

    private Long enable;

    private Long importKey;

    private String creater;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    private Long appCategory;

    private Long directAutoCupsPush;

    private Long indirectAutoCupsPush;

    private Long isAtm;
}

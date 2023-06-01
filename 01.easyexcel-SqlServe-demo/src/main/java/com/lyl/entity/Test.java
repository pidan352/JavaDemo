package com.lyl.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDateTime;

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
 * @since 2023-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test")
public class Test implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableField("ID")
	private String id;

	@TableField("TEST")
	private Double test;

	@TableField(value = "createdate", fill = FieldFill.INSERT)
	private LocalDateTime createdate;

	@TableField("mic")
	private String mic;


}

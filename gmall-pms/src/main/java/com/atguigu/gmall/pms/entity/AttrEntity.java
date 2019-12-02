package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品属性
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 11:23:37
 */
@ApiModel
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性id
	 */
	@TableId
	@ApiModelProperty(name = "attrId",value = "属性id")
	private Long attrId;
	/**
	 * 属性名
	 */
	@ApiModelProperty(name = "attrName",value = "属性名")
	private String attrName;
	/**
	 * 是否需要检索[0-不需要，1-需要]
	 */
	@ApiModelProperty(name = "searchType",value = "是否需要检索[0-不需要，1-需要]")
	private Integer searchType;
	/**
	 * 值类型[0-为单个值，1-可以选择多个值]
	 */
	@ApiModelProperty(name = "valueType",value = "值类型[0-为单个值，1-可以选择多个值]")
	private Integer valueType;
	/**
	 * 属性图标
	 */
	@ApiModelProperty(name = "icon",value = "属性图标")
	private String icon;
	/**
	 * 可选值列表[用逗号分隔]
	 */
	@ApiModelProperty(name = "valueSelect",value = "可选值列表[用逗号分隔]")
	private String valueSelect;
	/**
	 * 属性类型[0-销售属性，1-基本属性]
	 */
	@ApiModelProperty(name = "attrType",value = "属性类型[0-销售属性，1-基本属性]")
	private Integer attrType;
	/**
	 * 启用状态[0 - 禁用，1 - 启用]
	 */
	@ApiModelProperty(name = "enable",value = "启用状态[0 - 禁用，1 - 启用]")
	private Long enable;
	/**
	 * 所属分类
	 */
	@ApiModelProperty(name = "catelogId",value = "所属分类")
	private Long catelogId;
	/**
	 * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
	 */
	@ApiModelProperty(name = "showDesc",value = "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
	private Integer showDesc;

}

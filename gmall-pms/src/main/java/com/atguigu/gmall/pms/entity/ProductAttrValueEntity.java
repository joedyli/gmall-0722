package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spu属性值
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 11:23:36
 */
@ApiModel
@Data
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 商品id
	 */
	@ApiModelProperty(name = "spuId",value = "商品id")
	private Long spuId;
	/**
	 * 属性id
	 */
	@ApiModelProperty(name = "attrId",value = "属性id")
	private Long attrId;
	/**
	 * 属性名
	 */
	@ApiModelProperty(name = "attrName",value = "属性名")
	private String attrName;
	/**
	 * 属性值
	 */
	@ApiModelProperty(name = "attrValue",value = "属性值")
	private String attrValue;
	/**
	 * 顺序
	 */
	@ApiModelProperty(name = "attrSort",value = "顺序")
	private Integer attrSort;
	/**
	 * 快速展示【是否展示在介绍上；0-否 1-是】
	 */
	@ApiModelProperty(name = "quickShow",value = "快速展示【是否展示在介绍上；0-否 1-是】")
	private Integer quickShow;

}

package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sku信息
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 11:23:36
 */
@ApiModel
@Data
@TableName("pms_sku_info")
public class SkuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * skuId
	 */
	@TableId
	@ApiModelProperty(name = "skuId",value = "skuId")
	private Long skuId;
	/**
	 * spuId
	 */
	@ApiModelProperty(name = "spuId",value = "spuId")
	private Long spuId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "skuCode",value = "")
	private String skuCode;
	/**
	 * sku名称
	 */
	@ApiModelProperty(name = "skuName",value = "sku名称")
	private String skuName;
	/**
	 * sku介绍描述
	 */
	@ApiModelProperty(name = "skuDesc",value = "sku介绍描述")
	private String skuDesc;
	/**
	 * 所属分类id
	 */
	@ApiModelProperty(name = "catalogId",value = "所属分类id")
	private Long catalogId;
	/**
	 * 品牌id
	 */
	@ApiModelProperty(name = "brandId",value = "品牌id")
	private Long brandId;
	/**
	 * 默认图片
	 */
	@ApiModelProperty(name = "skuDefaultImg",value = "默认图片")
	private String skuDefaultImg;
	/**
	 * 标题
	 */
	@ApiModelProperty(name = "skuTitle",value = "标题")
	private String skuTitle;
	/**
	 * 副标题
	 */
	@ApiModelProperty(name = "skuSubtitle",value = "副标题")
	private String skuSubtitle;
	/**
	 * 价格
	 */
	@ApiModelProperty(name = "price",value = "价格")
	private BigDecimal price;
	/**
	 * 重量
	 */
	@ApiModelProperty(name = "weight",value = "重量")
	private BigDecimal weight;

}

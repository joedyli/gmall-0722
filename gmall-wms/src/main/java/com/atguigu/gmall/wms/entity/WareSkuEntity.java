package com.atguigu.gmall.wms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品库存
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-04 10:34:01
 */
@ApiModel
@Data
@TableName("wms_ware_sku")
public class WareSkuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * sku_id
	 */
	@ApiModelProperty(name = "skuId",value = "sku_id")
	private Long skuId;
	/**
	 * 仓库id
	 */
	@ApiModelProperty(name = "wareId",value = "仓库id")
	private Long wareId;
	/**
	 * 库存数
	 */
	@ApiModelProperty(name = "stock",value = "库存数")
	private Integer stock;
	/**
	 * sku_name
	 */
	@ApiModelProperty(name = "skuName",value = "sku_name")
	private String skuName;
	/**
	 * 锁定库存
	 */
	@ApiModelProperty(name = "stockLocked",value = "锁定库存")
	private Integer stockLocked;

}

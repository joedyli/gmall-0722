package com.atguigu.gmall.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 秒杀活动商品关联
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 15:59:14
 */
@ApiModel
@Data
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 活动id
	 */
	@ApiModelProperty(name = "promotionId",value = "活动id")
	private Long promotionId;
	/**
	 * 活动场次id
	 */
	@ApiModelProperty(name = "promotionSessionId",value = "活动场次id")
	private Long promotionSessionId;
	/**
	 * 商品id
	 */
	@ApiModelProperty(name = "skuId",value = "商品id")
	private Long skuId;
	/**
	 * 秒杀价格
	 */
	@ApiModelProperty(name = "seckillPrice",value = "秒杀价格")
	private BigDecimal seckillPrice;
	/**
	 * 秒杀总量
	 */
	@ApiModelProperty(name = "seckillCount",value = "秒杀总量")
	private BigDecimal seckillCount;
	/**
	 * 每人限购数量
	 */
	@ApiModelProperty(name = "seckillLimit",value = "每人限购数量")
	private BigDecimal seckillLimit;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "seckillSort",value = "排序")
	private Integer seckillSort;

}

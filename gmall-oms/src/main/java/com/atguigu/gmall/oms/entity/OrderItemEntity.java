package com.atguigu.gmall.oms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单项信息
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-18 10:25:39
 */
@ApiModel
@Data
@TableName("oms_order_item")
public class OrderItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * order_id
	 */
	@ApiModelProperty(name = "orderId",value = "order_id")
	private Long orderId;
	/**
	 * order_sn
	 */
	@ApiModelProperty(name = "orderSn",value = "order_sn")
	private String orderSn;
	/**
	 * spu_id
	 */
	@ApiModelProperty(name = "spuId",value = "spu_id")
	private Long spuId;
	/**
	 * spu_name
	 */
	@ApiModelProperty(name = "spuName",value = "spu_name")
	private String spuName;
	/**
	 * spu_pic
	 */
	@ApiModelProperty(name = "spuPic",value = "spu_pic")
	private String spuPic;
	/**
	 * 品牌
	 */
	@ApiModelProperty(name = "spuBrand",value = "品牌")
	private String spuBrand;
	/**
	 * 商品分类id
	 */
	@ApiModelProperty(name = "categoryId",value = "商品分类id")
	private Long categoryId;
	/**
	 * 商品sku编号
	 */
	@ApiModelProperty(name = "skuId",value = "商品sku编号")
	private Long skuId;
	/**
	 * 商品sku名字
	 */
	@ApiModelProperty(name = "skuName",value = "商品sku名字")
	private String skuName;
	/**
	 * 商品sku图片
	 */
	@ApiModelProperty(name = "skuPic",value = "商品sku图片")
	private String skuPic;
	/**
	 * 商品sku价格
	 */
	@ApiModelProperty(name = "skuPrice",value = "商品sku价格")
	private BigDecimal skuPrice;
	/**
	 * 商品购买的数量
	 */
	@ApiModelProperty(name = "skuQuantity",value = "商品购买的数量")
	private Integer skuQuantity;
	/**
	 * 商品销售属性组合（JSON）
	 */
	@ApiModelProperty(name = "skuAttrsVals",value = "商品销售属性组合（JSON）")
	private String skuAttrsVals;
	/**
	 * 商品促销分解金额
	 */
	@ApiModelProperty(name = "promotionAmount",value = "商品促销分解金额")
	private BigDecimal promotionAmount;
	/**
	 * 优惠券优惠分解金额
	 */
	@ApiModelProperty(name = "couponAmount",value = "优惠券优惠分解金额")
	private BigDecimal couponAmount;
	/**
	 * 积分优惠分解金额
	 */
	@ApiModelProperty(name = "integrationAmount",value = "积分优惠分解金额")
	private BigDecimal integrationAmount;
	/**
	 * 该商品经过优惠后的分解金额
	 */
	@ApiModelProperty(name = "realAmount",value = "该商品经过优惠后的分解金额")
	private BigDecimal realAmount;
	/**
	 * 赠送积分
	 */
	@ApiModelProperty(name = "giftIntegration",value = "赠送积分")
	private Integer giftIntegration;
	/**
	 * 赠送成长值
	 */
	@ApiModelProperty(name = "giftGrowth",value = "赠送成长值")
	private Integer giftGrowth;

}

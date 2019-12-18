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
 * 支付信息表
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-18 10:25:39
 */
@ApiModel
@Data
@TableName("oms_payment_info")
public class PaymentInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 订单号（对外业务号）
	 */
	@ApiModelProperty(name = "orderSn",value = "订单号（对外业务号）")
	private String orderSn;
	/**
	 * 订单id
	 */
	@ApiModelProperty(name = "orderId",value = "订单id")
	private Long orderId;
	/**
	 * 支付宝交易流水号
	 */
	@ApiModelProperty(name = "alipayTradeNo",value = "支付宝交易流水号")
	private String alipayTradeNo;
	/**
	 * 支付总金额
	 */
	@ApiModelProperty(name = "totalAmount",value = "支付总金额")
	private BigDecimal totalAmount;
	/**
	 * 交易内容
	 */
	@ApiModelProperty(name = "subject",value = "交易内容")
	private String subject;
	/**
	 * 支付状态
	 */
	@ApiModelProperty(name = "paymentStatus",value = "支付状态")
	private String paymentStatus;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime",value = "创建时间")
	private Date createTime;
	/**
	 * 确认时间
	 */
	@ApiModelProperty(name = "confirmTime",value = "确认时间")
	private Date confirmTime;
	/**
	 * 回调内容
	 */
	@ApiModelProperty(name = "callbackContent",value = "回调内容")
	private String callbackContent;
	/**
	 * 回调时间
	 */
	@ApiModelProperty(name = "callbackTime",value = "回调时间")
	private Date callbackTime;

}

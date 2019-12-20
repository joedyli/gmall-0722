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
 * 订单
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-18 10:25:39
 */
@ApiModel
@Data
@TableName("oms_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * member_id
	 */
	@ApiModelProperty(name = "memberId",value = "member_id")
	private Long memberId;
	/**
	 * 订单号
	 */
	@ApiModelProperty(name = "orderSn",value = "订单号")
	private String orderSn;
	/**
	 * 使用的优惠券
	 */
	@ApiModelProperty(name = "couponId",value = "使用的优惠券")
	private Long couponId;
	/**
	 * create_time
	 */
	@ApiModelProperty(name = "createTime",value = "create_time")
	private Date createTime;
	/**
	 * 用户名
	 */
	@ApiModelProperty(name = "memberUsername",value = "用户名")
	private String memberUsername;
	/**
	 * 订单总额
	 */
	@ApiModelProperty(name = "totalAmount",value = "订单总额")
	private BigDecimal totalAmount;
	/**
	 * 应付总额
	 */
	@ApiModelProperty(name = "payAmount",value = "应付总额")
	private BigDecimal payAmount;
	/**
	 * 运费金额
	 */
	@ApiModelProperty(name = "freightAmount",value = "运费金额")
	private BigDecimal freightAmount;
	/**
	 * 促销优化金额（促销价、满减、阶梯价）
	 */
	@ApiModelProperty(name = "promotionAmount",value = "促销优化金额（促销价、满减、阶梯价）")
	private BigDecimal promotionAmount;
	/**
	 * 积分抵扣金额
	 */
	@ApiModelProperty(name = "integrationAmount",value = "积分抵扣金额")
	private BigDecimal integrationAmount;
	/**
	 * 优惠券抵扣金额
	 */
	@ApiModelProperty(name = "couponAmount",value = "优惠券抵扣金额")
	private BigDecimal couponAmount;
	/**
	 * 后台调整订单使用的折扣金额
	 */
	@ApiModelProperty(name = "discountAmount",value = "后台调整订单使用的折扣金额")
	private BigDecimal discountAmount;
	/**
	 * 支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】
	 */
	@ApiModelProperty(name = "payType",value = "支付方式【1->支付宝；2->微信；3->银联； 4->货到付款；】")
	private Integer payType;
	/**
	 * 订单来源[0->PC订单；1->app订单]
	 */
	@ApiModelProperty(name = "sourceType",value = "订单来源[0->PC订单；1->app订单]")
	private Integer sourceType;
	/**
	 * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
	 */
	@ApiModelProperty(name = "status",value = "订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】")
	private Integer status;
	/**
	 * 物流公司(配送方式)
	 */
	@ApiModelProperty(name = "deliveryCompany",value = "物流公司(配送方式)")
	private String deliveryCompany;
	/**
	 * 物流单号
	 */
	@ApiModelProperty(name = "deliverySn",value = "物流单号")
	private String deliverySn;
	/**
	 * 自动确认时间（天）
	 */
	@ApiModelProperty(name = "autoConfirmDay",value = "自动确认时间（天）")
	private Integer autoConfirmDay;
	/**
	 * 可以获得的积分
	 */
	@ApiModelProperty(name = "integration",value = "可以获得的积分")
	private Integer integration;
	/**
	 * 可以获得的成长值
	 */
	@ApiModelProperty(name = "growth",value = "可以获得的成长值")
	private Integer growth;
	/**
	 * 发票类型[0->不开发票；1->电子发票；2->纸质发票]
	 */
	@ApiModelProperty(name = "billType",value = "发票类型[0->不开发票；1->电子发票；2->纸质发票]")
	private Integer billType;
	/**
	 * 发票抬头
	 */
	@ApiModelProperty(name = "billHeader",value = "发票抬头")
	private String billHeader;
	/**
	 * 发票内容
	 */
	@ApiModelProperty(name = "billContent",value = "发票内容")
	private String billContent;
	/**
	 * 收票人电话
	 */
	@ApiModelProperty(name = "billReceiverPhone",value = "收票人电话")
	private String billReceiverPhone;
	/**
	 * 收票人邮箱
	 */
	@ApiModelProperty(name = "billReceiverEmail",value = "收票人邮箱")
	private String billReceiverEmail;
	/**
	 * 收货人姓名
	 */
	@ApiModelProperty(name = "receiverName",value = "收货人姓名")
	private String receiverName;
	/**
	 * 收货人电话
	 */
	@ApiModelProperty(name = "receiverPhone",value = "收货人电话")
	private String receiverPhone;
	/**
	 * 收货人邮编
	 */
	@ApiModelProperty(name = "receiverPostCode",value = "收货人邮编")
	private String receiverPostCode;
	/**
	 * 省份/直辖市
	 */
	@ApiModelProperty(name = "receiverProvince",value = "省份/直辖市")
	private String receiverProvince;
	/**
	 * 城市
	 */
	@ApiModelProperty(name = "receiverCity",value = "城市")
	private String receiverCity;
	/**
	 * 区
	 */
	@ApiModelProperty(name = "receiverRegion",value = "区")
	private String receiverRegion;
	/**
	 * 详细地址
	 */
	@ApiModelProperty(name = "receiverDetailAddress",value = "详细地址")
	private String receiverDetailAddress;
	/**
	 * 订单备注
	 */
	@ApiModelProperty(name = "note",value = "订单备注")
	private String note;
	/**
	 * 确认收货状态[0->未确认；1->已确认]
	 */
	@ApiModelProperty(name = "confirmStatus",value = "确认收货状态[0->未确认；1->已确认]")
	private Integer confirmStatus;
	/**
	 * 删除状态【0->未删除；1->已删除】
	 */
	@ApiModelProperty(name = "deleteStatus",value = "删除状态【0->未删除；1->已删除】")
	private Integer deleteStatus;
	/**
	 * 下单时使用的积分
	 */
	@ApiModelProperty(name = "useIntegration",value = "下单时使用的积分")
	private Integer useIntegration;
	/**
	 * 支付时间
	 */
	@ApiModelProperty(name = "paymentTime",value = "支付时间")
	private Date paymentTime;
	/**
	 * 发货时间
	 */
	@ApiModelProperty(name = "deliveryTime",value = "发货时间")
	private Date deliveryTime;
	/**
	 * 确认收货时间
	 */
	@ApiModelProperty(name = "receiveTime",value = "确认收货时间")
	private Date receiveTime;
	/**
	 * 评价时间
	 */
	@ApiModelProperty(name = "commentTime",value = "评价时间")
	private Date commentTime;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(name = "modifyTime",value = "修改时间")
	private Date modifyTime;

}

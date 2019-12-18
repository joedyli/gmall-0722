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
 * 订单退货申请
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-18 10:25:39
 */
@ApiModel
@Data
@TableName("oms_order_return_apply")
public class OrderReturnApplyEntity implements Serializable {
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
	 * 退货商品id
	 */
	@ApiModelProperty(name = "skuId",value = "退货商品id")
	private Long skuId;
	/**
	 * 订单编号
	 */
	@ApiModelProperty(name = "orderSn",value = "订单编号")
	private String orderSn;
	/**
	 * 申请时间
	 */
	@ApiModelProperty(name = "createTime",value = "申请时间")
	private Date createTime;
	/**
	 * 会员用户名
	 */
	@ApiModelProperty(name = "memberUsername",value = "会员用户名")
	private String memberUsername;
	/**
	 * 退款金额
	 */
	@ApiModelProperty(name = "returnAmount",value = "退款金额")
	private BigDecimal returnAmount;
	/**
	 * 退货人姓名
	 */
	@ApiModelProperty(name = "returnName",value = "退货人姓名")
	private String returnName;
	/**
	 * 退货人电话
	 */
	@ApiModelProperty(name = "returnPhone",value = "退货人电话")
	private String returnPhone;
	/**
	 * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
	 */
	@ApiModelProperty(name = "status",value = "申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]")
	private Integer status;
	/**
	 * 处理时间
	 */
	@ApiModelProperty(name = "handleTime",value = "处理时间")
	private Date handleTime;
	/**
	 * 商品图片
	 */
	@ApiModelProperty(name = "skuImg",value = "商品图片")
	private String skuImg;
	/**
	 * 商品名称
	 */
	@ApiModelProperty(name = "skuName",value = "商品名称")
	private String skuName;
	/**
	 * 商品品牌
	 */
	@ApiModelProperty(name = "skuBrand",value = "商品品牌")
	private String skuBrand;
	/**
	 * 商品销售属性(JSON)
	 */
	@ApiModelProperty(name = "skuAttrsVals",value = "商品销售属性(JSON)")
	private String skuAttrsVals;
	/**
	 * 退货数量
	 */
	@ApiModelProperty(name = "skuCount",value = "退货数量")
	private Integer skuCount;
	/**
	 * 商品单价
	 */
	@ApiModelProperty(name = "skuPrice",value = "商品单价")
	private BigDecimal skuPrice;
	/**
	 * 商品实际支付单价
	 */
	@ApiModelProperty(name = "skuRealPrice",value = "商品实际支付单价")
	private BigDecimal skuRealPrice;
	/**
	 * 原因
	 */
	@ApiModelProperty(name = "reason",value = "原因")
	private String reason;
	/**
	 * 描述
	 */
	@ApiModelProperty(name = "description述",value = "描述")
	private String description述;
	/**
	 * 凭证图片，以逗号隔开
	 */
	@ApiModelProperty(name = "descPics",value = "凭证图片，以逗号隔开")
	private String descPics;
	/**
	 * 处理备注
	 */
	@ApiModelProperty(name = "handleNote",value = "处理备注")
	private String handleNote;
	/**
	 * 处理人员
	 */
	@ApiModelProperty(name = "handleMan",value = "处理人员")
	private String handleMan;
	/**
	 * 收货人
	 */
	@ApiModelProperty(name = "receiveMan",value = "收货人")
	private String receiveMan;
	/**
	 * 收货时间
	 */
	@ApiModelProperty(name = "receiveTime",value = "收货时间")
	private Date receiveTime;
	/**
	 * 收货备注
	 */
	@ApiModelProperty(name = "receiveNote",value = "收货备注")
	private String receiveNote;
	/**
	 * 收货电话
	 */
	@ApiModelProperty(name = "receivePhone",value = "收货电话")
	private String receivePhone;
	/**
	 * 公司收货地址
	 */
	@ApiModelProperty(name = "companyAddress",value = "公司收货地址")
	private String companyAddress;

}

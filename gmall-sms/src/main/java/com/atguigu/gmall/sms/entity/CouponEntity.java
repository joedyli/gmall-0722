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
 * 优惠券信息
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 15:59:14
 */
@ApiModel
@Data
@TableName("sms_coupon")
public class CouponEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]
	 */
	@ApiModelProperty(name = "couponType",value = "优惠卷类型[0->全场赠券；1->会员赠券；2->购物赠券；3->注册赠券]")
	private Integer couponType;
	/**
	 * 优惠券图片
	 */
	@ApiModelProperty(name = "couponImg",value = "优惠券图片")
	private String couponImg;
	/**
	 * 优惠卷名字
	 */
	@ApiModelProperty(name = "couponName",value = "优惠卷名字")
	private String couponName;
	/**
	 * 数量
	 */
	@ApiModelProperty(name = "num",value = "数量")
	private Integer num;
	/**
	 * 金额
	 */
	@ApiModelProperty(name = "amount",value = "金额")
	private BigDecimal amount;
	/**
	 * 每人限领张数
	 */
	@ApiModelProperty(name = "perLimit",value = "每人限领张数")
	private Integer perLimit;
	/**
	 * 使用门槛
	 */
	@ApiModelProperty(name = "minPoint",value = "使用门槛")
	private BigDecimal minPoint;
	/**
	 * 开始时间
	 */
	@ApiModelProperty(name = "startTime",value = "开始时间")
	private Date startTime;
	/**
	 * 结束时间
	 */
	@ApiModelProperty(name = "endTime",value = "结束时间")
	private Date endTime;
	/**
	 * 使用类型[0->全场通用；1->指定分类；2->指定商品]
	 */
	@ApiModelProperty(name = "useType",value = "使用类型[0->全场通用；1->指定分类；2->指定商品]")
	private Integer useType;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "note",value = "备注")
	private String note;
	/**
	 * 发行数量
	 */
	@ApiModelProperty(name = "publishCount",value = "发行数量")
	private Integer publishCount;
	/**
	 * 已使用数量
	 */
	@ApiModelProperty(name = "useCount",value = "已使用数量")
	private Integer useCount;
	/**
	 * 领取数量
	 */
	@ApiModelProperty(name = "receiveCount",value = "领取数量")
	private Integer receiveCount;
	/**
	 * 可以领取的开始日期
	 */
	@ApiModelProperty(name = "enableStartTime",value = "可以领取的开始日期")
	private Date enableStartTime;
	/**
	 * 可以领取的结束日期
	 */
	@ApiModelProperty(name = "enableEndTime",value = "可以领取的结束日期")
	private Date enableEndTime;
	/**
	 * 优惠码
	 */
	@ApiModelProperty(name = "code",value = "优惠码")
	private String code;
	/**
	 * 可以领取的会员等级[0->不限等级，其他-对应等级]
	 */
	@ApiModelProperty(name = "memberLevel",value = "可以领取的会员等级[0->不限等级，其他-对应等级]")
	private Integer memberLevel;
	/**
	 * 发布状态[0-未发布，1-已发布]
	 */
	@ApiModelProperty(name = "publish",value = "发布状态[0-未发布，1-已发布]")
	private Integer publish;

}

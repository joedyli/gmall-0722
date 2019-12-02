package com.atguigu.gmall.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 秒杀商品通知订阅
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 15:59:14
 */
@ApiModel
@Data
@TableName("sms_seckill_sku_notice")
public class SeckillSkuNoticeEntity implements Serializable {
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
	 * sku_id
	 */
	@ApiModelProperty(name = "skuId",value = "sku_id")
	private Long skuId;
	/**
	 * 活动场次id
	 */
	@ApiModelProperty(name = "sessionId",value = "活动场次id")
	private Long sessionId;
	/**
	 * 订阅时间
	 */
	@ApiModelProperty(name = "subcribeTime",value = "订阅时间")
	private Date subcribeTime;
	/**
	 * 发送时间
	 */
	@ApiModelProperty(name = "sendTime",value = "发送时间")
	private Date sendTime;
	/**
	 * 通知方式[0-短信，1-邮件]
	 */
	@ApiModelProperty(name = "noticeType",value = "通知方式[0-短信，1-邮件]")
	private Integer noticeType;

}

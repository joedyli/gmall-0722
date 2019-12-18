package com.atguigu.gmall.oms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单操作历史记录
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-18 10:25:39
 */
@ApiModel
@Data
@TableName("oms_order_operate_history")
public class OrderOperateHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 订单id
	 */
	@ApiModelProperty(name = "orderId",value = "订单id")
	private Long orderId;
	/**
	 * 操作人[用户；系统；后台管理员]
	 */
	@ApiModelProperty(name = "operateMan",value = "操作人[用户；系统；后台管理员]")
	private String operateMan;
	/**
	 * 操作时间
	 */
	@ApiModelProperty(name = "createTime",value = "操作时间")
	private Date createTime;
	/**
	 * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
	 */
	@ApiModelProperty(name = "orderStatus",value = "订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】")
	private Integer orderStatus;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "note",value = "备注")
	private String note;

}

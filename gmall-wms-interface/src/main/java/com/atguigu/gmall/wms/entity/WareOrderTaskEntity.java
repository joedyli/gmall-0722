package com.atguigu.gmall.wms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 库存工作单
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-04 10:34:01
 */
@ApiModel
@Data
@TableName("wms_ware_order_task")
public class WareOrderTaskEntity implements Serializable {
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
	 * 收货人
	 */
	@ApiModelProperty(name = "consignee",value = "收货人")
	private String consignee;
	/**
	 * 收货人电话
	 */
	@ApiModelProperty(name = "consigneeTel",value = "收货人电话")
	private String consigneeTel;
	/**
	 * 配送地址
	 */
	@ApiModelProperty(name = "deliveryAddress",value = "配送地址")
	private String deliveryAddress;
	/**
	 * 订单备注
	 */
	@ApiModelProperty(name = "orderComment",value = "订单备注")
	private String orderComment;
	/**
	 * 付款方式【 1:在线付款 2:货到付款】
	 */
	@ApiModelProperty(name = "paymentWay",value = "付款方式【 1:在线付款 2:货到付款】")
	private Integer paymentWay;
	/**
	 * 任务状态
	 */
	@ApiModelProperty(name = "taskStatus",value = "任务状态")
	private Integer taskStatus;
	/**
	 * 订单描述
	 */
	@ApiModelProperty(name = "orderBody",value = "订单描述")
	private String orderBody;
	/**
	 * 物流单号
	 */
	@ApiModelProperty(name = "trackingNo",value = "物流单号")
	private String trackingNo;
	/**
	 * create_time
	 */
	@ApiModelProperty(name = "createTime",value = "create_time")
	private Date createTime;
	/**
	 * 仓库id
	 */
	@ApiModelProperty(name = "wareId",value = "仓库id")
	private Long wareId;
	/**
	 * 工作单备注
	 */
	@ApiModelProperty(name = "taskComment",value = "工作单备注")
	private String taskComment;

}

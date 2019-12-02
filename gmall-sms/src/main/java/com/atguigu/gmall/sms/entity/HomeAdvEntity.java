package com.atguigu.gmall.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 首页轮播广告
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 15:59:14
 */
@ApiModel
@Data
@TableName("sms_home_adv")
public class HomeAdvEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 名字
	 */
	@ApiModelProperty(name = "name",value = "名字")
	private String name;
	/**
	 * 图片地址
	 */
	@ApiModelProperty(name = "pic",value = "图片地址")
	private String pic;
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
	 * 状态
	 */
	@ApiModelProperty(name = "status",value = "状态")
	private Integer status;
	/**
	 * 点击数
	 */
	@ApiModelProperty(name = "clickCount",value = "点击数")
	private Integer clickCount;
	/**
	 * 广告详情连接地址
	 */
	@ApiModelProperty(name = "url",value = "广告详情连接地址")
	private String url;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "note",value = "备注")
	private String note;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;
	/**
	 * 发布者
	 */
	@ApiModelProperty(name = "publisherId",value = "发布者")
	private Long publisherId;
	/**
	 * 审核者
	 */
	@ApiModelProperty(name = "authId",value = "审核者")
	private Long authId;

}

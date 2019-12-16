package com.atguigu.gmall.ums.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会员收货地址
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-16 09:40:32
 */
@ApiModel
@Data
@TableName("ums_member_receive_address")
public class MemberReceiveAddressEntity implements Serializable {
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
	 * 收货人姓名
	 */
	@ApiModelProperty(name = "name",value = "收货人姓名")
	private String name;
	/**
	 * 电话
	 */
	@ApiModelProperty(name = "phone",value = "电话")
	private String phone;
	/**
	 * 邮政编码
	 */
	@ApiModelProperty(name = "postCode",value = "邮政编码")
	private String postCode;
	/**
	 * 省份/直辖市
	 */
	@ApiModelProperty(name = "province",value = "省份/直辖市")
	private String province;
	/**
	 * 城市
	 */
	@ApiModelProperty(name = "city",value = "城市")
	private String city;
	/**
	 * 区
	 */
	@ApiModelProperty(name = "region",value = "区")
	private String region;
	/**
	 * 详细地址(街道)
	 */
	@ApiModelProperty(name = "detailAddress",value = "详细地址(街道)")
	private String detailAddress;
	/**
	 * 省市区代码
	 */
	@ApiModelProperty(name = "areacode",value = "省市区代码")
	private String areacode;
	/**
	 * 是否默认
	 */
	@ApiModelProperty(name = "defaultStatus",value = "是否默认")
	private Integer defaultStatus;

}

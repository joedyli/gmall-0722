package com.atguigu.gmall.ums.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会员等级
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-16 09:40:32
 */
@ApiModel
@Data
@TableName("ums_member_level")
public class MemberLevelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 等级名称
	 */
	@ApiModelProperty(name = "name",value = "等级名称")
	private String name;
	/**
	 * 等级需要的成长值
	 */
	@ApiModelProperty(name = "growthPoint",value = "等级需要的成长值")
	private Integer growthPoint;
	/**
	 * 是否为默认等级[0->不是；1->是]
	 */
	@ApiModelProperty(name = "defaultStatus",value = "是否为默认等级[0->不是；1->是]")
	private Integer defaultStatus;
	/**
	 * 免运费标准
	 */
	@ApiModelProperty(name = "freeFreightPoint",value = "免运费标准")
	private BigDecimal freeFreightPoint;
	/**
	 * 每次评价获取的成长值
	 */
	@ApiModelProperty(name = "commentGrowthPoint",value = "每次评价获取的成长值")
	private Integer commentGrowthPoint;
	/**
	 * 是否有免邮特权
	 */
	@ApiModelProperty(name = "priviledgeFreeFreight",value = "是否有免邮特权")
	private Integer priviledgeFreeFreight;
	/**
	 * 是否有会员价格特权
	 */
	@ApiModelProperty(name = "priviledgeMemberPrice",value = "是否有会员价格特权")
	private Integer priviledgeMemberPrice;
	/**
	 * 是否有生日特权
	 */
	@ApiModelProperty(name = "priviledgeBirthday",value = "是否有生日特权")
	private Integer priviledgeBirthday;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "note",value = "备注")
	private String note;

}

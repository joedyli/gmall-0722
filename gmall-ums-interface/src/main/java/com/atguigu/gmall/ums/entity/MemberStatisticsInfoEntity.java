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
 * 会员统计信息
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-16 09:40:32
 */
@ApiModel
@Data
@TableName("ums_member_statistics_info")
public class MemberStatisticsInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 会员id
	 */
	@ApiModelProperty(name = "memberId",value = "会员id")
	private Long memberId;
	/**
	 * 累计消费金额
	 */
	@ApiModelProperty(name = "consumeAmount",value = "累计消费金额")
	private BigDecimal consumeAmount;
	/**
	 * 累计优惠金额
	 */
	@ApiModelProperty(name = "couponAmount",value = "累计优惠金额")
	private BigDecimal couponAmount;
	/**
	 * 订单数量
	 */
	@ApiModelProperty(name = "orderCount",value = "订单数量")
	private Integer orderCount;
	/**
	 * 优惠券数量
	 */
	@ApiModelProperty(name = "couponCount",value = "优惠券数量")
	private Integer couponCount;
	/**
	 * 评价数
	 */
	@ApiModelProperty(name = "commentCount",value = "评价数")
	private Integer commentCount;
	/**
	 * 退货数量
	 */
	@ApiModelProperty(name = "returnOrderCount",value = "退货数量")
	private Integer returnOrderCount;
	/**
	 * 登录次数
	 */
	@ApiModelProperty(name = "loginCount",value = "登录次数")
	private Integer loginCount;
	/**
	 * 关注数量
	 */
	@ApiModelProperty(name = "attendCount",value = "关注数量")
	private Integer attendCount;
	/**
	 * 粉丝数量
	 */
	@ApiModelProperty(name = "fansCount",value = "粉丝数量")
	private Integer fansCount;
	/**
	 * 收藏的商品数量
	 */
	@ApiModelProperty(name = "collectProductCount",value = "收藏的商品数量")
	private Integer collectProductCount;
	/**
	 * 收藏的专题活动数量
	 */
	@ApiModelProperty(name = "collectSubjectCount",value = "收藏的专题活动数量")
	private Integer collectSubjectCount;
	/**
	 * 收藏的评论数量
	 */
	@ApiModelProperty(name = "collectCommentCount",value = "收藏的评论数量")
	private Integer collectCommentCount;
	/**
	 * 邀请的朋友数量
	 */
	@ApiModelProperty(name = "inviteFriendCount",value = "邀请的朋友数量")
	private Integer inviteFriendCount;

}

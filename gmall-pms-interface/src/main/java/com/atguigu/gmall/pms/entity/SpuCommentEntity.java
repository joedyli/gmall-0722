package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品评价
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 11:23:36
 */
@ApiModel
@Data
@TableName("pms_spu_comment")
public class SpuCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * sku_id
	 */
	@ApiModelProperty(name = "skuId",value = "sku_id")
	private Long skuId;
	/**
	 * spu_id
	 */
	@ApiModelProperty(name = "spuId",value = "spu_id")
	private Long spuId;
	/**
	 * 商品名字
	 */
	@ApiModelProperty(name = "spuName",value = "商品名字")
	private String spuName;
	/**
	 * 会员昵称
	 */
	@ApiModelProperty(name = "memberNickName",value = "会员昵称")
	private String memberNickName;
	/**
	 * 星级
	 */
	@ApiModelProperty(name = "star",value = "星级")
	private Integer star;
	/**
	 * 会员ip
	 */
	@ApiModelProperty(name = "memberIp",value = "会员ip")
	private String memberIp;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime",value = "创建时间")
	private Date createTime;
	/**
	 * 显示状态[0-不显示，1-显示]
	 */
	@ApiModelProperty(name = "showStatus",value = "显示状态[0-不显示，1-显示]")
	private Integer showStatus;
	/**
	 * 购买时属性组合
	 */
	@ApiModelProperty(name = "spuAttributes",value = "购买时属性组合")
	private String spuAttributes;
	/**
	 * 点赞数
	 */
	@ApiModelProperty(name = "likesCount",value = "点赞数")
	private Integer likesCount;
	/**
	 * 回复数
	 */
	@ApiModelProperty(name = "replyCount",value = "回复数")
	private Integer replyCount;
	/**
	 * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
	 */
	@ApiModelProperty(name = "resources",value = "评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]")
	private String resources;
	/**
	 * 内容
	 */
	@ApiModelProperty(name = "content",value = "内容")
	private String content;
	/**
	 * 用户头像
	 */
	@ApiModelProperty(name = "memberIcon",value = "用户头像")
	private String memberIcon;
	/**
	 * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
	 */
	@ApiModelProperty(name = "commentType",value = "评论类型[0 - 对商品的直接评论，1 - 对评论的回复]")
	private Integer commentType;

}

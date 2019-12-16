package com.atguigu.gmall.ums.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会员
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-16 09:40:32
 */
@ApiModel
@Data
@TableName("ums_member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 会员等级id
	 */
	@ApiModelProperty(name = "levelId",value = "会员等级id")
	private Long levelId;
	/**
	 * 用户名
	 */
	@ApiModelProperty(name = "username",value = "用户名")
	private String username;
	/**
	 * 密码
	 */
	@ApiModelProperty(name = "password",value = "密码")
	private String password;
	/**
	 * 昵称
	 */
	@ApiModelProperty(name = "nickname",value = "昵称")
	private String nickname;
	/**
	 * 手机号码
	 */
	@ApiModelProperty(name = "mobile",value = "手机号码")
	private String mobile;
	/**
	 * 邮箱
	 */
	@ApiModelProperty(name = "email",value = "邮箱")
	private String email;
	/**
	 * 盐
	 */
	@ApiModelProperty(name = "salt",value = "盐")
	private String salt;
	/**
	 * 头像
	 */
	@ApiModelProperty(name = "header",value = "头像")
	private String header;
	/**
	 * 性别
	 */
	@ApiModelProperty(name = "gender",value = "性别")
	private Integer gender;
	/**
	 * 生日
	 */
	@ApiModelProperty(name = "birth",value = "生日")
	private Date birth;
	/**
	 * 所在城市
	 */
	@ApiModelProperty(name = "city",value = "所在城市")
	private String city;
	/**
	 * 职业
	 */
	@ApiModelProperty(name = "job",value = "职业")
	private String job;
	/**
	 * 个性签名
	 */
	@ApiModelProperty(name = "sign",value = "个性签名")
	private String sign;
	/**
	 * 用户来源
	 */
	@ApiModelProperty(name = "sourceType",value = "用户来源")
	private Integer sourceType;
	/**
	 * 积分
	 */
	@ApiModelProperty(name = "integration",value = "积分")
	private Integer integration;
	/**
	 * 成长值
	 */
	@ApiModelProperty(name = "growth",value = "成长值")
	private Integer growth;
	/**
	 * 启用状态
	 */
	@ApiModelProperty(name = "status",value = "启用状态")
	private Integer status;
	/**
	 * 注册时间
	 */
	@ApiModelProperty(name = "createTime",value = "注册时间")
	private Date createTime;

}

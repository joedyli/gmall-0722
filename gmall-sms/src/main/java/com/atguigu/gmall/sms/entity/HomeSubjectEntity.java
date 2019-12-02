package com.atguigu.gmall.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 首页专题表【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 15:59:14
 */
@ApiModel
@Data
@TableName("sms_home_subject")
public class HomeSubjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "id")
	private Long id;
	/**
	 * 专题名字
	 */
	@ApiModelProperty(name = "name",value = "专题名字")
	private String name;
	/**
	 * 专题标题
	 */
	@ApiModelProperty(name = "title",value = "专题标题")
	private String title;
	/**
	 * 专题副标题
	 */
	@ApiModelProperty(name = "subTitle",value = "专题副标题")
	private String subTitle;
	/**
	 * 显示状态
	 */
	@ApiModelProperty(name = "status",value = "显示状态")
	private Integer status;
	/**
	 * 详情连接
	 */
	@ApiModelProperty(name = "url",value = "详情连接")
	private String url;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;
	/**
	 * 专题图片地址
	 */
	@ApiModelProperty(name = "img",value = "专题图片地址")
	private String img;

}

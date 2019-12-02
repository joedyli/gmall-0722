package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品三级分类
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 11:23:36
 */
@ApiModel
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类id
	 */
	@TableId
	@ApiModelProperty(name = "catId",value = "分类id")
	private Long catId;
	/**
	 * 分类名称
	 */
	@ApiModelProperty(name = "name",value = "分类名称")
	private String name;
	/**
	 * 父分类id
	 */
	@ApiModelProperty(name = "parentCid",value = "父分类id")
	private Long parentCid;
	/**
	 * 层级
	 */
	@ApiModelProperty(name = "catLevel",value = "层级")
	private Integer catLevel;
	/**
	 * 是否显示[0-不显示，1显示]
	 */
	@ApiModelProperty(name = "showStatus",value = "是否显示[0-不显示，1显示]")
	private Integer showStatus;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;
	/**
	 * 图标地址
	 */
	@ApiModelProperty(name = "icon",value = "图标地址")
	private String icon;
	/**
	 * 计量单位
	 */
	@ApiModelProperty(name = "productUnit",value = "计量单位")
	private String productUnit;
	/**
	 * 商品数量
	 */
	@ApiModelProperty(name = "productCount",value = "商品数量")
	private Integer productCount;

}

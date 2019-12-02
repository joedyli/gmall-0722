package com.atguigu.gmall.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 品牌
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 11:23:36
 */
@ApiModel
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@ApiModelProperty(name = "brandId",value = "品牌id")
	private Long brandId;
	/**
	 * 品牌名
	 */
	@ApiModelProperty(name = "name",value = "品牌名")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@ApiModelProperty(name = "logo",value = "品牌logo地址")
	private String logo;
	/**
	 * 介绍
	 */
	@ApiModelProperty(name = "descript",value = "介绍")
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	@ApiModelProperty(name = "showStatus",value = "显示状态[0-不显示；1-显示]")
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@ApiModelProperty(name = "firstLetter",value = "检索首字母")
	private String firstLetter;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "sort",value = "排序")
	private Integer sort;

}

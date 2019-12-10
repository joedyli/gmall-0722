package com.atguigu.gmall.wms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 全国省市区信息
 * 
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-04 10:34:01
 */
@ApiModel
@Data
@TableName("wms_sh_area")
public class ShAreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "ID")
	private Integer id;
	/**
	 * 父id
	 */
	@ApiModelProperty(name = "pid",value = "父id")
	private Integer pid;
	/**
	 * 简称
	 */
	@ApiModelProperty(name = "shortname",value = "简称")
	private String shortname;
	/**
	 * 名称
	 */
	@ApiModelProperty(name = "name",value = "名称")
	private String name;
	/**
	 * 全称
	 */
	@ApiModelProperty(name = "mergerName",value = "全称")
	private String mergerName;
	/**
	 * 层级 0 1 2 省市区县
	 */
	@ApiModelProperty(name = "level",value = "层级 0 1 2 省市区县")
	private Integer level;
	/**
	 * 拼音
	 */
	@ApiModelProperty(name = "pinyin",value = "拼音")
	private String pinyin;
	/**
	 * 长途区号
	 */
	@ApiModelProperty(name = "code",value = "长途区号")
	private String code;
	/**
	 * 邮编
	 */
	@ApiModelProperty(name = "zipCode",value = "邮编")
	private String zipCode;
	/**
	 * 首字母
	 */
	@ApiModelProperty(name = "first",value = "首字母")
	private String first;
	/**
	 * 经度
	 */
	@ApiModelProperty(name = "lng",value = "经度")
	private String lng;
	/**
	 * 纬度
	 */
	@ApiModelProperty(name = "lat",value = "纬度")
	private String lat;

}

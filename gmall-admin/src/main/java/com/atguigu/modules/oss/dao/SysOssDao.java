/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 *
 * https://www.guli.cloud
 *
 * 版权所有，侵权必究！
 */

package com.atguigu.modules.oss.dao;

import com.atguigu.modules.oss.entity.SysOssEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}

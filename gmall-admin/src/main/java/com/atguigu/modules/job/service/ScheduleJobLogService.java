/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 *
 * https://www.guli.cloud
 *
 * 版权所有，侵权必究！
 */

package com.atguigu.modules.job.service;

import com.atguigu.modules.job.entity.ScheduleJobLogEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}

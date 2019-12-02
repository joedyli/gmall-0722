/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 *
 * https://www.guli.cloud
 *
 * 版权所有，侵权必究！
 */

package com.atguigu.modules.sys.controller;


import com.atguigu.common.annotation.SysLog;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.common.validator.ValidatorUtils;
import com.atguigu.modules.sys.entity.SysConfigEntity;
import com.atguigu.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统配置信息
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {
	@Autowired
	private SysConfigService sysConfigService;
	
	/**
	 * 所有配置列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:config:list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = sysConfigService.queryPage(params);

		return R.ok().put("page", page);
	}
	
	
	/**
	 * 配置信息
	 */
	@GetMapping("/info/{id}")
	@RequiresPermissions("sys:config:info")
	public R info(@PathVariable("id") Long id){
		SysConfigEntity config = sysConfigService.getById(id);
		
		return R.ok().put("config", config);
	}
	
	/**
	 * 保存配置
	 */
	@SysLog("保存配置")
	@PostMapping("/save")
	@RequiresPermissions("sys:config:save")
	public R save(@RequestBody SysConfigEntity config){
		ValidatorUtils.validateEntity(config);

		sysConfigService.saveConfig(config);
		
		return R.ok();
	}
	
	/**
	 * 修改配置
	 */
	@SysLog("修改配置")
	@PostMapping("/update")
	@RequiresPermissions("sys:config:update")
	public R update(@RequestBody SysConfigEntity config){
		ValidatorUtils.validateEntity(config);
		
		sysConfigService.update(config);
		
		return R.ok();
	}
	
	/**
	 * 删除配置
	 */
	@SysLog("删除配置")
	@PostMapping("/delete")
	@RequiresPermissions("sys:config:delete")
	public R delete(@RequestBody Long[] ids){
		sysConfigService.deleteBatch(ids);
		
		return R.ok();
	}

}

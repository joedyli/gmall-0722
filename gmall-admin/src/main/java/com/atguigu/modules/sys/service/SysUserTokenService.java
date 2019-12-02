/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 *
 * https://www.guli.cloud
 *
 * 版权所有，侵权必究！
 */

package com.atguigu.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.R;
import com.atguigu.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}

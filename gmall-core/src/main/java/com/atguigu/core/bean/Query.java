/**
 * Copyright (c) 2016-2019 谷粒开源 All rights reserved.
 *
 * https://www.guli.cloud
 *
 * 版权所有，侵权必究！
 */

package com.atguigu.core.bean;

import com.atguigu.core.utils.SQLFilter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;

/**
 * 查询参数
 *
 * @author Mark sunlightcs@gmail.com
 */
public class Query<T> {


    public IPage<T> getPage(QueryCondition params) {
        return this.getPage(params, null, false);
    }



    public IPage<T> getPage(QueryCondition params, String defaultOrderField, boolean isAsc) {
        //分页参数
        long curPage = 1;
        long limit = 10;

        if(params.getPage() != null){
            curPage = params.getPage();
        }
        if(params.getLimit() != null){
            limit = params.getLimit();
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        //分页参数
//        params.put(Constant.PAGE, page);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject(params.getSidx());
        String order = params.getOrder();

        //前端字段排序
        if(StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)){
            if("asc".equalsIgnoreCase(order)) {
                return page.setAsc(orderField);
            }else {
                return page.setDesc(orderField);
            }
        }

        //默认排序
        if(isAsc) {
            page.setAsc(defaultOrderField);
        }else {
            page.setDesc(defaultOrderField);
        }

        return page;
    }





}

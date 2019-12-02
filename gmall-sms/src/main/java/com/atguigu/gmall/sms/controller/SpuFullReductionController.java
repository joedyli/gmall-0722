package com.atguigu.gmall.sms.controller;

import java.util.Arrays;
import java.util.Map;


import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.QueryCondition;
import com.atguigu.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gmall.sms.entity.SpuFullReductionEntity;
import com.atguigu.gmall.sms.service.SpuFullReductionService;




/**
 * 商品满减信息
 *
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 15:59:14
 */
@Api(tags = "商品满减信息 管理")
@RestController
@RequestMapping("sms/spufullreduction")
public class SpuFullReductionController {
    @Autowired
    private SpuFullReductionService spuFullReductionService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sms:spufullreduction:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = spuFullReductionService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('sms:spufullreduction:info')")
    public Resp<SpuFullReductionEntity> info(@PathVariable("id") Long id){
		SpuFullReductionEntity spuFullReduction = spuFullReductionService.getById(id);

        return Resp.ok(spuFullReduction);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sms:spufullreduction:save')")
    public Resp<Object> save(@RequestBody SpuFullReductionEntity spuFullReduction){
		spuFullReductionService.save(spuFullReduction);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sms:spufullreduction:update')")
    public Resp<Object> update(@RequestBody SpuFullReductionEntity spuFullReduction){
		spuFullReductionService.updateById(spuFullReduction);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sms:spufullreduction:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		spuFullReductionService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}

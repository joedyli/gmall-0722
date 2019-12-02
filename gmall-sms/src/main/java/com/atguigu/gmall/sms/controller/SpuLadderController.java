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

import com.atguigu.gmall.sms.entity.SpuLadderEntity;
import com.atguigu.gmall.sms.service.SpuLadderService;




/**
 * 商品阶梯价格
 *
 * @author fengge
 * @email lxf@atguigu.com
 * @date 2019-12-02 15:59:14
 */
@Api(tags = "商品阶梯价格 管理")
@RestController
@RequestMapping("sms/spuladder")
public class SpuLadderController {
    @Autowired
    private SpuLadderService spuLadderService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('sms:spuladder:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = spuLadderService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('sms:spuladder:info')")
    public Resp<SpuLadderEntity> info(@PathVariable("id") Long id){
		SpuLadderEntity spuLadder = spuLadderService.getById(id);

        return Resp.ok(spuLadder);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('sms:spuladder:save')")
    public Resp<Object> save(@RequestBody SpuLadderEntity spuLadder){
		spuLadderService.save(spuLadder);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('sms:spuladder:update')")
    public Resp<Object> update(@RequestBody SpuLadderEntity spuLadder){
		spuLadderService.updateById(spuLadder);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('sms:spuladder:delete')")
    public Resp<Object> delete(@RequestBody Long[] ids){
		spuLadderService.removeByIds(Arrays.asList(ids));

        return Resp.ok(null);
    }

}

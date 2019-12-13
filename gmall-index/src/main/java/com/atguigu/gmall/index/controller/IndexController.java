package com.atguigu.gmall.index.controller;

import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.index.service.IndexService;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.atguigu.gmall.pms.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.ReactiveStreamsMongoClientDependsOnBeanFactoryPostProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("cates")
    public Resp<List<CategoryEntity>> queryLvl1Categories(){

        List<CategoryEntity> categoryEntities = this.indexService.queryLvl1Categories();
        return Resp.ok(categoryEntities);
    }

    @GetMapping("cates/{pid}")
    public Resp<List<CategoryVO>> querySubCategories(@PathVariable("pid")Long pid){
        List<CategoryVO> categoryVOS = indexService.querySubCategories(pid);
        return Resp.ok(categoryVOS);
    }

    @GetMapping("test/lock")
    public String testLock(){
        this.indexService.testLock();
        return "ok";
    }

    @GetMapping("test/read")
    public String testRead(){
        return this.indexService.testRead();
    }

    @GetMapping("test/write")
    public String testWrite(){
        return this.indexService.testWrite();
    }

    @GetMapping("test/latch")
    public String testLatch() throws InterruptedException {
        return this.indexService.testLatch();
    }

    @GetMapping("test/countdown")
    public String testCountdown(){
        return this.indexService.testCountdown();
    }
}

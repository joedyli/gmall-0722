package com.atguigu.gmall.item.service;

import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.item.feign.GmallPmsClient;
import com.atguigu.gmall.item.feign.GmallSmsClient;
import com.atguigu.gmall.item.feign.GmallWmsClient;
import com.atguigu.gmall.item.vo.ItemVO;
import com.atguigu.gmall.pms.entity.*;
import com.atguigu.gmall.pms.vo.ItemGroupVO;
import com.atguigu.gmall.sms.vo.SaleVO;
import com.atguigu.gmall.wms.entity.WareSkuEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Service
public class ItemService {

    @Autowired
    private GmallPmsClient pmsClient;

    @Autowired
    private GmallSmsClient smsClient;

    @Autowired
    private GmallWmsClient wmsClient;

    public ItemVO queryItemVO(Long skuId) {
        ItemVO itemVO = new ItemVO();

        // 设置skuId
        itemVO.setSkuId(skuId);

        // 根据id查询sku
        Resp<SkuInfoEntity> skuResp = this.pmsClient.querySkuById(skuId);
        SkuInfoEntity skuInfoEntity = skuResp.getData();
        if (skuInfoEntity == null) {
            return itemVO;
        }
        itemVO.setSkuTitle(skuInfoEntity.getSkuTitle());
        itemVO.setSubTitle(skuInfoEntity.getSkuSubtitle());
        itemVO.setPrice(skuInfoEntity.getPrice());
        itemVO.setWeight(skuInfoEntity.getWeight());
        // 获取spuId
        Long spuId = skuInfoEntity.getSpuId();

        // 根据sku中的spuId查询spu
        Resp<SpuInfoEntity> spuResp = this.pmsClient.querySpuById(spuId);
        SpuInfoEntity spuInfoEntity = spuResp.getData();
        itemVO.setSpuId(spuId);
        if (spuInfoEntity != null) {
            itemVO.setSpuName(spuInfoEntity.getSpuName());
        }

        // 根据skuId查询图片列表
        Resp<List<SkuImagesEntity>> skuImagesResp = this.pmsClient.querySkuImagesBySkuId(skuId);
        List<SkuImagesEntity> skuImagesEntities = skuImagesResp.getData();
        itemVO.setPics(skuImagesEntities);

        // 根据sku中brandId和CategoryId查询品牌和分类
        Resp<BrandEntity> brandEntityResp = this.pmsClient.queryBrandById(skuInfoEntity.getBrandId());
        BrandEntity brandEntity = brandEntityResp.getData();
        itemVO.setBrandEntity(brandEntity);
        Resp<CategoryEntity> categoryEntityResp = this.pmsClient.queryCategoryById(skuInfoEntity.getCatalogId());
        CategoryEntity categoryEntity = categoryEntityResp.getData();
        itemVO.setCategoryEntity(categoryEntity);

        // 根据skuId查询营销信息
        Resp<List<SaleVO>> salesResp = this.smsClient.querySalesBySkuId(skuId);
        List<SaleVO> saleVOList = salesResp.getData();
        itemVO.setSales(saleVOList);

        // 根据skuId查询库存信息
        Resp<List<WareSkuEntity>> wareResp = this.wmsClient.queryWareSkusBySkuId(skuId);
        List<WareSkuEntity> wareSkuEntities = wareResp.getData();
        itemVO.setStore(wareSkuEntities.stream().anyMatch(wareSkuEntity -> wareSkuEntity.getStock() > 0));

        // 根据spuId查询所有skuIds, 再去查询所有的销售属性
        Resp<List<SkuSaleAttrValueEntity>> saleAttrValueResp = this.pmsClient.querySkuSaleAttrValuesBySpuId(spuId);
        List<SkuSaleAttrValueEntity> SkuSaleAttrValueEntities = saleAttrValueResp.getData();
        itemVO.setSaleAttrs(SkuSaleAttrValueEntities);

        // 根据spuId查询商品描述（海报）
        Resp<SpuInfoDescEntity> spuInfoDescEntityResp = this.pmsClient.querySpuDescBySpuId(spuId);
        SpuInfoDescEntity descEntity = spuInfoDescEntityResp.getData();
        if (descEntity != null) {
            String decript = descEntity.getDecript();
            String[] split = StringUtils.split(decript, ",");
            itemVO.setImages(Arrays.asList(split));
        }

        // 根据spuId和cateId查询组及组下规格参数（带值）
        Resp<List<ItemGroupVO>> itemGroupResp = this.pmsClient.queryItemGroupVOByCidAndSpuId(skuInfoEntity.getCatalogId(), spuId);
        List<ItemGroupVO> itemGroupVOS = itemGroupResp.getData();
        itemVO.setGroups(itemGroupVOS);

        return itemVO;
    }

    public static void main(String[] args) {

        CompletableFuture.allOf(
                CompletableFuture.completedFuture("hello completedFuture1"),
                CompletableFuture.completedFuture("hello completedFuture2"),
                CompletableFuture.completedFuture("hello completedFuture3"),
                CompletableFuture.completedFuture("hello completedFuture4")
        ).join();


        CompletableFuture.supplyAsync(()->{
            System.out.println("runAsync......");
//            int i = 1 / 0;
            return "hello supplyAsync";
        }).thenApply(t -> {
            System.out.println(t);
            return "hello thenApply1";
        }).thenApply(t -> {
            System.out.println(t);
            return "hello thenApply2";
        }).thenAccept(t -> {
            System.out.println(t);
        }).whenComplete((t, u) -> {
            System.out.println("t: " + t);
            System.out.println(u);
        }).handleAsync((t, u) -> {
            System.out.println("t" + t);
            System.out.println(u);
            return "hello handler";
        }).thenCombine(CompletableFuture.completedFuture("hello completedFuture"), (t, u) -> {
            System.out.println(t);
            System.out.println(u);
            return "hello thenCombine";
        });



        // 1.继承thread基类
//        new MyThread().start();
        // 2.实现runnable接口
//        new Thread(new MyRunnable()).start();
//        new Thread(() -> {
//            System.out.println("thread start..." + Thread.currentThread().getName());
//            System.out.println("-=================================");
//            System.out.println("thread end... ");
//        }, "runnable").start();
        // 3.callabe接口：有返回值，可以处理异常
//        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
//        new Thread(futureTask).start();
//        try {
//            System.out.println(futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        // 4. 线程池
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 50, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), (Runnable r, ThreadPoolExecutor executor) -> {
//            System.out.println("执行了拒绝策略");
//        });
//        for (int i = 0; i < 50; i++) {
//            threadPoolExecutor.execute(()->{
//                System.out.println("thread start..." + Thread.currentThread().getName());
//                System.out.println("-=================================");
//                System.out.println("thread end... ");
//            });
//        }
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("thread start..." + Thread.currentThread().getName());
        System.out.println("-=================================");
        System.out.println("thread end... ");
        return "hello";
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("thread start..." + Thread.currentThread().getName());
        System.out.println("-=================================");
        System.out.println("thread end... ");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("thread start...");
        System.out.println("-=================================");
        System.out.println("thread end... ");
    }
}

package com.atguigu.gmall.cart.listener;

import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.cart.feign.GmallPmsClient;
import com.atguigu.gmall.pms.entity.SkuInfoEntity;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CartListener {

    @Autowired
    private GmallPmsClient pmsClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "gmall:cart:";

    private static final String PRICE_PREFIX = "gmall:sku:";

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "CART-ITEM-QUEUE", durable = "true"),
            exchange = @Exchange(value = "GMALL-PMS-EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"item.update"}
    ))
    public void listener(Long spuId){

        Resp<List<SkuInfoEntity>> skuResp = this.pmsClient.querySkusBySpuId(spuId);
        List<SkuInfoEntity> skuInfoEntities = skuResp.getData();
        skuInfoEntities.forEach(skuInfoEntity -> {
            this.redisTemplate.opsForValue().set(PRICE_PREFIX + skuInfoEntity.getSkuId(), skuInfoEntity.getPrice().toString());
        });
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "ORDER-CART-QUEUE", durable = "true"),
            exchange = @Exchange(value = "GMALL-ORDER-EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"cart.delete"}
    ))
    public void deleteListener(Map<String, Object> map){
        Long userId = (Long) map.get("userId");
        List<Object> skuIds = (List<Object>)map.get("skuIds");
        BoundHashOperations<String, Object, Object> hashOps = this.redisTemplate.boundHashOps(KEY_PREFIX + userId);
        List<String> skus = skuIds.stream().map(skuId -> skuId.toString()).collect(Collectors.toList());
        String[] ids = skus.toArray(new String[skus.size()]);
        hashOps.delete(ids);
    }
}

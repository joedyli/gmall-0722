package com.atguigu.gmall.oms.listener;

import com.atguigu.gmall.oms.dao.OrderDao;
import com.atguigu.gmall.oms.entity.OrderEntity;
import com.atguigu.gmall.ums.vo.UserBoundsVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderListener {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RabbitListener(queues = {"ORDER-DEAD-QUEUE"})
    public void closeOrder(String orderToken){
        // 如果执行了关单操作
        if(this.orderDao.closeOrder(orderToken) == 1){
            // 解锁库存
            this.amqpTemplate.convertAndSend("GMALL-ORDER-EXCHANGE", "stock.unlock", orderToken);
        }
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "ORDER-PAY-QUEUE", durable = "true"),
            exchange = @Exchange(value = "GMALL-ORDER-EXCHANGE", ignoreDeclarationExceptions = "true", type = ExchangeTypes.TOPIC),
            key = {"order.pay"}
    ))
    public void payOrder(String orderToken){

        // 更新订单状态
        if (this.orderDao.payOrder(orderToken) == 1) {
            // 减库存
            this.amqpTemplate.convertAndSend("GMALL-ORDER-EXCHANGE", "stock.minus", orderToken);

            // 加积分
            OrderEntity orderEntity = this.orderDao.selectOne(new QueryWrapper<OrderEntity>().eq("order_sn", orderToken));
            UserBoundsVO boundsVO = new UserBoundsVO();
            boundsVO.setMemberId(orderEntity.getMemberId());
            boundsVO.setGrowth(orderEntity.getGrowth());
            boundsVO.setIntegration(orderEntity.getIntegration());
            this.amqpTemplate.convertAndSend("GMALL-ORDER-EXCHANGE", "user.bounds", boundsVO);
        }
    }
}

package com.atguigu.gmall.order.service;

import com.atguigu.core.bean.UserInfo;
import com.atguigu.gmall.order.feign.*;
import com.atguigu.gmall.order.interceptors.LoginInterceptor;
import com.atguigu.gmall.order.vo.OrderConfirmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private GmallPmsClient pmsClient;

    @Autowired
    private GmallOmsClient omsClient;

    @Autowired
    private GmallCartClient cartClient;

    @Autowired
    private GmallUmsClient umsClient;

    @Autowired
    private GmallSmsClient smsClient;

    @Autowired
    private GmallWmsClient wmsClient;

    public OrderConfirmVO confirm() {

        UserInfo userInfo = LoginInterceptor.getUserInfo();
        Long userId = userInfo.getId();
        if (userId == null) {
            return null;
        }

        // 获取用户的收货地址列表， 根据用户id查询收货地址列表

        // 获取购物车中选中的商品信息  skuId count

        // 查询用户信息，获取积分

        // 生成一个唯一标志，防止重复提交（响应到页面有一份，有一份保存到redis中）


        return null;
    }
}

package com.atguigu.gmall.order.controller;

import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.order.service.OrderService;
import com.atguigu.gmall.order.vo.OrderConfirmVO;
import com.atguigu.gmall.oms.vo.OrderSubmitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("confirm")
    public Resp<OrderConfirmVO> confirm(){

        OrderConfirmVO confirmVO = this.orderService.confirm();
        return Resp.ok(confirmVO);
    }

    @PostMapping("submit")
    public Resp<Object> submit(@RequestBody OrderSubmitVO submitVO){

        this.orderService.submit(submitVO);
        return  Resp.ok(null);
    }
}

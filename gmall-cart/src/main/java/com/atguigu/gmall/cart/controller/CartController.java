package com.atguigu.gmall.cart.controller;

import com.atguigu.core.bean.Resp;
import com.atguigu.gmall.cart.pojo.Cart;
import com.atguigu.gmall.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Resp<Object> addCart(@RequestBody Cart cart){

        this.cartService.addCart(cart);

        return Resp.ok(null);
    }

    @GetMapping
    public Resp<List<Cart>> queryCarts(){

        List<Cart> carts = this.cartService.queryCarts();
        return Resp.ok(carts);
    }

    @PostMapping("update")
    public Resp<Object> updateCart(@RequestBody Cart cart){

        this.cartService.updateCart(cart);
        return Resp.ok(null);
    }

    @GetMapping("{userId}")
    public Resp<List<Cart>> queryCheckedCartsByUserId(@PathVariable("userId")Long userId){
        List<Cart> carts = this.cartService.queryCheckedCartsByUserId(userId);
        return Resp.ok(carts);
    }

    @PostMapping("delete/{skuId}")
    public Resp<Object> deleteCart(@PathVariable("skuId")Long skuId){
        this.cartService.deleteCart(skuId);
        return Resp.ok(null);
    }

    @GetMapping("test")
    public String test(HttpServletRequest request){
        return "hello cart!";
    }
}

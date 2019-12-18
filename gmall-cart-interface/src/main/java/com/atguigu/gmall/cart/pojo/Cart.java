package com.atguigu.gmall.cart.pojo;

import com.atguigu.gmall.pms.entity.SkuSaleAttrValueEntity;
import com.atguigu.gmall.sms.vo.SaleVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Cart {

    private Long skuId;
    private String title;
    private String defaultImage;
    private BigDecimal price;
    private BigDecimal currentPrice;
    private Integer count;
    private Boolean store;
    private List<SkuSaleAttrValueEntity> saleAttrValues;
    private List<SaleVO> sales;
    private Boolean check;
}

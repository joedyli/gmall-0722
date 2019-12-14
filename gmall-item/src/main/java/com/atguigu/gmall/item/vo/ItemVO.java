package com.atguigu.gmall.item.vo;

import com.atguigu.gmall.pms.entity.BrandEntity;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.atguigu.gmall.pms.entity.SkuImagesEntity;
import com.atguigu.gmall.pms.entity.SkuSaleAttrValueEntity;
import com.atguigu.gmall.pms.vo.ItemGroupVO;
import com.atguigu.gmall.sms.vo.SaleVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ItemVO {

    private Long skuId;
    private CategoryEntity categoryEntity;
    private BrandEntity brandEntity;
    private Long spuId;
    private String spuName;

    private String skuTitle;
    private String subTitle;
    private BigDecimal price;
    private BigDecimal weight;

    private List<SkuImagesEntity> pics; // sku的图片列表
    private List<SaleVO> sales; // 营销信息

    private Boolean store; // 是否有货

    private List<SkuSaleAttrValueEntity> saleAttrs; // 销售属性

    private List<String> images; // spu的海报

    private List<ItemGroupVO> groups; // 规格参数组及组下的规格参数（带值）
}

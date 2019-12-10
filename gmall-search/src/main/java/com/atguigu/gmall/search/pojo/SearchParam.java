package com.atguigu.gmall.search.pojo;

import lombok.Data;

@Data
public class SearchParam {

    // search?catelog3=手机&catelog3=配件&brand=1&props=43:3g-4g-5g&props=45:4.7-5.0
    // &order=2:asc/desc&priceFrom=100&priceTo=10000&pageNum=1&pageSize=12&keyword=手机
    private String[] catelog3;//三级分类id

    private String[] brand;//品牌id

    private String keyword;//检索的关键字

    // order=1:asc  排序规则   0:asc
    private String order;// 0：综合排序  1：销量  2：价格

    private Integer pageNum = 1;//分页信息

    //props=2:全高清&  如果前端想传入很多值    props=2:青年-老人-女士

    //2:win10-android-
    //3:4g
    //4:5.5
    private String[] props;//页面提交的数组

    private Integer pageSize = 12;

    private Integer priceFrom;//价格区间开始
    private Integer priceTo;//价格区间结束
}

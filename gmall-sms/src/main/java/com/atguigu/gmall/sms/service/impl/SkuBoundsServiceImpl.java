package com.atguigu.gmall.sms.service.impl;

import com.atguigu.gmall.sms.dao.SkuFullReductionDao;
import com.atguigu.gmall.sms.dao.SkuLadderDao;
import com.atguigu.gmall.sms.entity.SkuFullReductionEntity;
import com.atguigu.gmall.sms.entity.SkuLadderEntity;
import com.atguigu.gmall.sms.vo.SaleVO;
import com.atguigu.gmall.sms.vo.SkuSaleVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.core.bean.PageVo;
import com.atguigu.core.bean.Query;
import com.atguigu.core.bean.QueryCondition;

import com.atguigu.gmall.sms.dao.SkuBoundsDao;
import com.atguigu.gmall.sms.entity.SkuBoundsEntity;
import com.atguigu.gmall.sms.service.SkuBoundsService;
import org.springframework.transaction.annotation.Transactional;


@Service("skuBoundsService")
public class SkuBoundsServiceImpl extends ServiceImpl<SkuBoundsDao, SkuBoundsEntity> implements SkuBoundsService {

    @Autowired
    private SkuLadderDao skuLadderDao;

    @Autowired
    private SkuFullReductionDao reductionDao;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SkuBoundsEntity> page = this.page(
                new Query<SkuBoundsEntity>().getPage(params),
                new QueryWrapper<SkuBoundsEntity>()
        );

        return new PageVo(page);
    }

    @Transactional
    @Override
    public void saveSale(SkuSaleVO skuSaleVO) {

        // 3.1. 保存sms_sku_bounds
        SkuBoundsEntity skuBoundsEntity = new SkuBoundsEntity();
        skuBoundsEntity.setSkuId(skuSaleVO.getSkuId());
        skuBoundsEntity.setGrowBounds(skuSaleVO.getGrowBounds());
        skuBoundsEntity.setBuyBounds(skuSaleVO.getBuyBounds());
        List<Integer> work = skuSaleVO.getWork();
        skuBoundsEntity.setWork(work.get(3) * 1 + work.get(2) * 2 + work.get(1) * 4 + work.get(0) * 8);
        this.save(skuBoundsEntity);

        // 3.2. 保存sms_sku_ladder
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        skuLadderEntity.setSkuId(skuSaleVO.getSkuId());
        skuLadderEntity.setFullCount(skuSaleVO.getFullCount());
        skuLadderEntity.setDiscount(skuSaleVO.getDiscount());
        skuLadderEntity.setAddOther(skuSaleVO.getLadderAddOther());
        this.skuLadderDao.insert(skuLadderEntity);

        // 3.3. 保存sms_sku_full_reduction
        SkuFullReductionEntity reductionEntity = new SkuFullReductionEntity();
        reductionEntity.setSkuId(skuSaleVO.getSkuId());
        reductionEntity.setFullPrice(skuSaleVO.getFullPrice());
        reductionEntity.setReducePrice(skuSaleVO.getReducePrice());
        reductionEntity.setAddOther(skuSaleVO.getFullAddOther());
        this.reductionDao.insert(reductionEntity);
    }

    @Override
    public List<SaleVO> querySalesBySkuId(Long skuId) {
        List<SaleVO> saleVOS = new ArrayList<>();
        // 查询积分信息
        SkuBoundsEntity skuBoundsEntity = this.getOne(new QueryWrapper<SkuBoundsEntity>().eq("sku_id", skuId));
        if (skuBoundsEntity != null) {
            SaleVO boundsVO = new SaleVO();
            boundsVO.setType("积分");
            StringBuffer sb = new StringBuffer();
            if (skuBoundsEntity.getGrowBounds() != null && skuBoundsEntity.getGrowBounds().intValue() > 0) {
                sb.append("成长积分送" + skuBoundsEntity.getGrowBounds());
            }
            if (skuBoundsEntity.getBuyBounds() != null && skuBoundsEntity.getBuyBounds().intValue() > 0) {
                if (StringUtils.isNotBlank(sb)) {
                    sb.append("，");
                }
                sb.append("赠送积分送" + skuBoundsEntity.getBuyBounds());
            }
            boundsVO.setDesc(sb.toString());
            saleVOS.add(boundsVO);
        }

        // 查询打折
        SkuLadderEntity skuLadderEntity = this.skuLadderDao.selectOne(new QueryWrapper<SkuLadderEntity>().eq("sku_id", skuId));
        if (skuBoundsEntity != null) {
            SaleVO ladderVO = new SaleVO();
            ladderVO.setType("打折");
            ladderVO.setDesc("满" + skuLadderEntity.getFullCount() + "件，打" + skuLadderEntity.getDiscount().divide(new BigDecimal(10)) + "折");
            saleVOS.add(ladderVO);
        }

        // 查询满减
        SkuFullReductionEntity reductionEntity = this.reductionDao.selectOne(new QueryWrapper<SkuFullReductionEntity>().eq("sku_id", skuId));
        if (reductionEntity != null) {
            SaleVO reductionVO = new SaleVO();
            reductionVO.setType("满减");
            reductionVO.setDesc("满" + reductionEntity.getFullPrice() + "减" + reductionEntity.getReducePrice());

            saleVOS.add(reductionVO);
        }

        return saleVOS;
    }

}
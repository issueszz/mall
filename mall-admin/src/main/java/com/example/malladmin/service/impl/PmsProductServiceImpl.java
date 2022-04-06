package com.example.malladmin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.example.malladmin.dao.*;
import com.example.malladmin.dto.PmsProductParam;
import com.example.malladmin.dto.PmsProductQueryParam;
import com.example.malladmin.dto.PmsProductResult;
import com.example.malladmin.service.PmsProductService;
import com.example.mallmbg.mapper.PmsProductMapper;
import com.example.mallmbg.model.PmsProduct;
import com.example.mallmbg.model.PmsProductExample;
import com.example.mallmbg.model.PmsSkuStock;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PmsProductServiceImpl implements PmsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductServiceImpl.class);

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Autowired
    private PmsProductLadderDao pmsProductLadderDao;

    @Autowired
    private PmsMemberPriceDao memberPriceDao;

    @Autowired
    private PmsProductFullReductionDao productFullReductionDao;

    @Autowired
    private PmsSkuStockDao skuStockDao;

    @Autowired
    private PmsProductAttributeValueDao productAttributeValueDao;

    @Autowired
    private CmsSubjectProductRelationDao subjectProductRelationDao;

    @Autowired
    private CmsPrefrenceAreaProductRelationDao prefrenceAreaProductRelationDao;

    @Autowired
    private PmsProductDao productDao;

    @Override
    public List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProductExample example = new PmsProductExample();
        PmsProductExample.Criteria criteria = example.createCriteria();

        /*筛选未删除的商品*/
        criteria.andDeleteStatusEqualTo(0);

        /*筛选上架状态*/
        if (pmsProductQueryParam.getPublishStatus() != null) {
            criteria.andPublishStatusEqualTo(pmsProductQueryParam.getPublishStatus());
        }

        /*筛选审核状态*/
        if (pmsProductQueryParam.getVerifyStatus() != null) {
            criteria.andVerifyStatusEqualTo(pmsProductQueryParam.getVerifyStatus());
        }

        /*商品属性编号*/
        if (pmsProductQueryParam.getProductCategoryId() != null) {
            criteria.andProductCategoryIdEqualTo(pmsProductQueryParam.getProductCategoryId());
        }

        /*品牌编号*/
        if (pmsProductQueryParam.getBrandId() != null) {
            criteria.andBrandIdEqualTo(pmsProductQueryParam.getBrandId());
        }

        /*商品编号*/
        if (!StrUtil.isEmpty(pmsProductQueryParam.getProductSn())) {
            criteria.andProductSnEqualTo(pmsProductQueryParam.getProductSn());
        }

        /*关键字模糊查询*/
        if (!StrUtil.isEmpty(pmsProductQueryParam.getKeyword())) {
            criteria.andKeywordsLike("%" + pmsProductQueryParam.getKeyword() + "%");
        }

        return pmsProductMapper.selectByExample(example);
    }

    @Override
    public int create(PmsProductParam pmsProductParam) {
        // 基本商品信息
        PmsProduct product = pmsProductParam;
        product.setId(null);
        pmsProductMapper.insertSelective(product);
        Long productId = product.getId();
        // 会员价格
        relateAndInsertList(memberPriceDao, pmsProductParam.getMemberPriceList(), productId);
        // 阶梯价格
        relateAndInsertList(pmsProductLadderDao, pmsProductParam.getProductLadderList(), productId);
        // 满减价格
        relateAndInsertList(productFullReductionDao, pmsProductParam.getProductFullReductionList(), productId);
        // sku编码预处理
        handleSkuStockCode(pmsProductParam.getSkuStockList(), productId);
        // 添加sku库存信息
        relateAndInsertList(skuStockDao, pmsProductParam.getSkuStockList(), productId);
        // 添加商品参数，添加自定义商品规格
        relateAndInsertList(productAttributeValueDao, pmsProductParam.getProductAttributeValueList(), productId);
        // 关联专题
        relateAndInsertList(subjectProductRelationDao, pmsProductParam.getSubjectProductRelationList(), productId);
        // 关联优选
        relateAndInsertList(prefrenceAreaProductRelationDao, pmsProductParam.getPrefrenceAreaProductRelationList(), productId);
        return 1;
    }

    /*处理sku编码*/
    private void handleSkuStockCode(List<PmsSkuStock> skuStocks, Long productId) {
        if (CollUtil.isEmpty(skuStocks)) return;
        for (int i = 0; i < skuStocks.size(); i++) {
            PmsSkuStock skuStock = skuStocks.get(i);
            if (StrUtil.isEmpty(skuStock.getSkuCode())) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                StringBuilder builder = new StringBuilder();
                // 取日期前四位
                builder.append(dateFormat.format(new Date()));
                // 取商品id四位
                builder.append(String.format("%04d", productId));
                // 取当前索引三位
                builder.append(String.format("%03d", i + 1));
                skuStock.setSkuCode(builder.toString());
            }
        }
    }

    /*为添加新商品提供的插入功能*/
    private void relateAndInsertList(Object dao, List dataList, Long productId) {
        try {
            if (CollUtil.isEmpty(dataList)) return;
            for (Object item : dataList) {
                Method setId = item.getClass().getMethod("setId", Long.class);
                setId.invoke(item, (Long) null);
                Method setProductId = item.getClass().getMethod("setProductId", Long.class);
                setProductId.invoke(item, productId);
            }
            Method insertList = dao.getClass().getMethod("insertList", List.class);
            insertList.invoke(dao, dataList);
        }catch (Exception e) {
            LOGGER.warn("创建商品出错:{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        PmsProduct product = new PmsProduct();
        product.setDeleteStatus(deleteStatus);

        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);


        return pmsProductMapper.updateByExampleSelective(product, example);
    }

    @Override
    public PmsProductResult getUpdateInfo(Long id) {
        return productDao.getUpdateInfo(id);
    }
}

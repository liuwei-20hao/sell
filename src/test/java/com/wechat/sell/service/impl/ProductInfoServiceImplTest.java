package com.wechat.sell.service.impl;

import com.wechat.sell.dao.ProductInfoDao;
import com.wechat.sell.entity.ProductInfo;
import com.wechat.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @Autowired
    private ProductInfoDao productInforepository;
    @Test
    public void findOne() {
        ProductInfo productInfo = productInforepository.findById("123").get();
        Assert.assertNotNull("123", productInfo.getProductId());
        System.out.println(productInfo);
    }

    @Test
    public void findAll() {
        List<ProductInfo> all = productInforepository.findAll();
        Assert.assertNotEquals(0, all.size());
    }

    @Test
    public void findByProductStatus() {
        PageRequest pageRequest = new PageRequest(1,2);
        Page<ProductInfo> all = productInforepository.findAll(pageRequest);
        all.getTotalElements();
    }

    @Test
    public void save() {
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("124");
        productInfo.setProductName("油条");
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("双份");
        productInfo.setProductPrice(BigDecimal.valueOf(5));
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfo.setProductStock(100);
        productInfo.setProductIcon("www.xxx.com");
        productInfoService.save(productInfo);
    }
}
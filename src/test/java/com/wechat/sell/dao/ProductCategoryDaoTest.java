package com.wechat.sell.dao;

import com.wechat.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao repository;

    @Test
    public void findOneTest() {
        ProductCategory  productCategory = null;
        Optional<ProductCategory> productCategorys = repository.findById(1);
        if(productCategorys!=null && productCategorys.isPresent()){
            productCategory = productCategorys.get();
        }
        System.out.println(productCategory);
    }

    @Test
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//      Assert.assertNotEquals(null, result);
    }

}
package com.wechat.sell.dao;

import com.wechat.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID = "110110";
    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(1, 3);
        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, result.getTotalElements());
    }

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1");
        orderMaster.setBuyerName("lw");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("china");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMasterDao.save(orderMaster);
    }

    @Test
    public void findone() {
        OrderMaster orderMaster = orderMasterDao.findById("1537326110427332608").get();
        System.out.println(orderMaster);
    }
}
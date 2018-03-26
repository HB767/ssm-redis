package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456789");
        orderDetail.setOrderId("1111111");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductId("2222222");
        orderDetail.setProductName("烤鸡");
        orderDetail.setProductPrice(new BigDecimal(1.5));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);
        System.out.println("kkkkkkkkkkkk");
        Assert.assertNotNull(result);
       // Assert.assertNull(result);
        System.out.println("ddddddddddd");
    }


    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("1111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}
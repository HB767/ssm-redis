package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID ="1101110";

    private final String ORDER_ID = "1521354443928495567";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("12345678978");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
    }

    @Test
    public void findOne() {
        OrderDTO resutl = orderService.findOne(ORDER_ID);
        log.info("[查询单个订单] result={}",resutl);
        Assert.assertEquals(ORDER_ID,resutl.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO resutl = orderService.findOne(ORDER_ID);
        OrderDTO orderDTO = orderService.cancel(resutl);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),resutl.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO resutl = orderService.findOne(ORDER_ID);
        OrderDTO orderDTO = orderService.finish(resutl);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),resutl.getOrderStatus());
    }

    /*支付订单*/
    @Test
    public void paid() {
        OrderDTO resutl = orderService.findOne(ORDER_ID);
        OrderDTO orderDTO = orderService.paid(resutl);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),resutl.getPayStatus());
    }
}
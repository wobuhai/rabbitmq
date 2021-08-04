package com.order.transactionalorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.order.transactionalorder.domain.Ordery;
import com.order.transactionalorder.mapper.OrderMapper;
import com.order.transactionalorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Ordery>
implements OrderService {
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public String addOrder(){
        Ordery ordery = new Ordery();
        ordery.setUserid(1);
        ordery.setOrderid(2);
        ordery.setOrderContent("来两桶泡面");

        baseMapper.insert(ordery);

        //运单处理
        String forObject = restTemplate.postForObject("http://localhost:8881/disp", ordery,String.class);
        return forObject;
    }

}





package com.order.transactionalorder.controller;

import com.order.transactionalorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @创建人 zwj
 * @创建时间 2021/8/4
 * @描述
 */
@RestController
public class orderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public String order(){
        String s = orderService.addOrder();
        return s;
    }
}

package com.disp.transactionaldisp.controller;

import com.disp.transactionaldisp.domain.Disp;
import com.disp.transactionaldisp.domain.Ordery;
import com.disp.transactionaldisp.service.DispService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @创建人 zwj
 * @创建时间 2021/8/4
 * @描述
 */
@RestController
public class dispController {
    @Autowired
    DispService dispService;

    @PostMapping("/disp")
    public String disp(@RequestBody Ordery ordery){
        Disp disp = new Disp();
        disp.setDisid(2);
        disp.setOrderid(ordery.getOrderid());
        disp.setStatus("配送中");
        disp.setUserid(1);
        dispService.save(disp);
        //模拟异常
        int i=1/0;
        return "配送订单ok";
    }
}

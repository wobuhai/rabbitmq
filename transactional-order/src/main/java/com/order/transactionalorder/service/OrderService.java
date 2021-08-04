package com.order.transactionalorder.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.order.transactionalorder.domain.Ordery;

/**
 *
 */
public interface OrderService extends IService<Ordery> {
    public String addOrder();

}

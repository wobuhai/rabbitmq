package com.p.provider;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @创建人 zwj
 * @创建时间 2021/8/3
 * @描述
 */
@RestController
public class PController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @GetMapping("/send")
    public void send(){
        rabbitTemplate.convertAndSend("ttl_direct_exchage","ttl","你看看你收到了");
    }
    @GetMapping("/config")
    public String config(){
        FanoutExchange fanout_order_exchange = new FanoutExchange("fanout_order2_exchange", true, false);
        amqpAdmin.declareExchange(fanout_order_exchange);
        amqpAdmin.declareQueue(new Queue("sms.fanout.queue",true));
        amqpAdmin.declareQueue(new Queue("duanxin.fanout.queue",true));
        amqpAdmin.declareQueue(new Queue("email.fanout.queue",true));
        amqpAdmin.declareBinding(new Binding("sms.fanout.queue",Binding.DestinationType.QUEUE,"fanout_order2_exchange","",null));
        amqpAdmin.declareBinding(new Binding("duanxin.fanout.queue",Binding.DestinationType.QUEUE,"fanout_order2_exchange","",null));
        amqpAdmin.declareBinding(new Binding("email.fanout.queue",Binding.DestinationType.QUEUE,"fanout_order2_exchange","",null));
        return "ok";
    }
    @GetMapping("/ttl/deadQueue")
    public String deadQueue(){
        amqpAdmin.declareExchange(new DirectExchange("ttl_direct_exchage",true,false));
        //死信交换机和死信队列
        amqpAdmin.declareExchange(new DirectExchange("dead_direct_exchage",true,false));
        amqpAdmin.declareQueue(new Queue("dead.direct.queue",true));
        amqpAdmin.declareBinding(new Binding("dead.direct.queue",Binding.DestinationType.QUEUE,"dead_direct_exchage","dead",null));

        //设置过期时间和死信队列
        HashMap<String, Object> map = new HashMap<>();
        map.put("x-dead-letter-exchange","dead_direct_exchage");
        map.put("x-dead-letter-routing-key","dead");
        map.put("x-message-ttl",5000);
        amqpAdmin.declareQueue(new Queue("ttl.direct.queue",true,false,false,map));
        amqpAdmin.declareBinding(new Binding("ttl.direct.queue",Binding.DestinationType.QUEUE,"ttl_direct_exchage","ttl",null));

        return "ok";
    }
}

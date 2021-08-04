package com.c.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @创建人 zwj
 * @创建时间 2021/8/3
 * @描述
 */
@Service
public class VConsumer {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "sms.topic.queue", durable = "true"),
            exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
            key = "#.sms.#"
    ))
    public void sms(Message o) throws UnsupportedEncodingException {
        String s = new String(o.getBody(), "UTF-8");
        System.out.println(s);
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "duanxin.topic.queue", durable = "true"),
            exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
            key = "#.duanxin.#"
    ))
    public void duanxin(Message o){
        System.out.println(o.getBody().toString());
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "email.topic.queue", durable = "true"),
            exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC),
            key = "#.email.#"
    ))
    public void email(Message o){
        System.out.println(o.getBody().toString());
    }
}

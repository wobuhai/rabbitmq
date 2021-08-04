import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @创建人 zwj
 * @创建时间 2021/8/3
 * @描述
 */
public class P {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory f = new ConnectionFactory();
        f.setPassword("guest");
        f.setUsername("guest");
        f.setHost("192.168.187.134");
        f.setPort(5672);
        f.setVirtualHost("/");
        Connection p = f.newConnection("P");

        Channel channel = p.createChannel();

        channel.queueDeclare("temp",true,false,false,null);

        channel.basicPublish("e","t",null,"hello".getBytes());
        System.out.println("发送成功");
    }
}

package rabbitMQ.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class DirectListener {

    @RabbitListener(queues = "directQueueOne")
    public void listerQueueR1(Channel channel, Message message) throws IOException {
        System.out.print("directQueueOne队列监听器1号收到消息 start:\n" + message);
        System.out.println("\ndata:" + new String(message.getBody(), "UTF-8"));
        System.out.println("\nproperties:" + message.getMessageProperties());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println("\ndirectQueueOne队列监听器1号收到消息 end");
    }

	@RabbitListener(queues = "directQueueTwo")
    public void displayMailTwo(Message message) throws Exception {
//        System.out.println("directQueueTwo队列监听器2号收到消息" + new String(message.getBody(), "UTF-8"));
        System.out.println("directQueueTwo队列监听器2号收到消息" + new String(message.getBody(), "UTF-8"));
	}

}

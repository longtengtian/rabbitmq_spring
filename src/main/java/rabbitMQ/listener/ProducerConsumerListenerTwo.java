package rabbitMQ.listener;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class ProducerConsumerListenerTwo {
	
	@RabbitListener(queues = "myQueue")
	public void displayMail(Channel channel, Message message) throws Exception {
		System.out.println("队列监听器2号收到消息 start:\n" + new String(message.getBody(), "UTF-8"));
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		System.out.println("队列监听器2号收到消息 end");
	}
}

package rabbitMQ.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import po.Mail;

import java.io.IOException;


@Component
public class DirectListener {
//	@RabbitListener(queues = "directQueueOne")
//	public void displayMail(Mail mail) throws Exception {
//		System.out.println("directQueueOne队列监听器1号收到消息"+mail.toString());
//	}

	@RabbitListener(queues = "directQueueTwo")
	public void displayMailTwo(Mail mail) throws Exception {
		System.out.println("directQueueTwo队列监听器2号收到消息"+mail.toString());
	}

	@RabbitListener(queues = "directQueueOne")
	public void listerQueueR1(Channel channel, Message message) throws IOException {
		System.out.print("directQueueOne队列监听器1号收到消息 start:\n" + message);
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		System.out.println("\ndirectQueueOne队列监听器1号收到消息 end");
	}

}

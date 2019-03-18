package rabbitMQ.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import po.Mail;

import java.io.IOException;


@Component
public class PublishSubscribeListener {
	@RabbitListener(queues = "queueOne")
	public void subscribe(Mail mail) throws IOException {
		System.out.println("订阅者1收到消息"+mail.toString());
	}

	@RabbitListener(queues = "queueTwo")
	public void subscribe2(Mail mail) throws IOException {
		System.out.println("订阅者2收到消息"+mail.toString());
	}
}

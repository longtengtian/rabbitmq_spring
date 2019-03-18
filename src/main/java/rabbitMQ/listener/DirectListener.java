package rabbitMQ.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import po.Mail;


@Component
public class DirectListener {
	@RabbitListener(queues = "directQueueOne")
	public void displayMail(Mail mail) throws Exception {
		System.out.println("directQueueOne队列监听器1号收到消息"+mail.toString());
	}

	@RabbitListener(queues = "directQueueTwo")
	public void displayMailTwo(Mail mail) throws Exception {
		System.out.println("directQueueTwo队列监听器2号收到消息"+mail.toString());
	}
}

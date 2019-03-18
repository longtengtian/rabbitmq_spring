package rabbitMQ.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import po.Mail;


@Component
public class DirectListener {
	@RabbitListener(queues = "directQueue1")
	public void displayMail(Mail mail) throws Exception {
		System.out.println("directQueue1队列监听器1号收到消息"+mail.toString());
	}

	@RabbitListener(queues = "directQueue2")
	public void displayMail2(Mail mail) throws Exception {
		System.out.println("directQueue2队列监听器2号收到消息"+mail.toString());
	}
}

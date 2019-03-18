package rabbitMQ.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import po.Mail;

@Component
public class ProducerConsumerListener {
	
	@RabbitListener(queues = "myQueue")
	public void displayMail(Mail mail) throws Exception {
		System.out.println("队列监听器1号收到消息"+mail.toString());
	}
}

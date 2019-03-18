package rabbitMQ.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import po.Mail;

import java.io.IOException;


@Component
public class TopicListener {
	@RabbitListener(queues = "topicQueue1")
	public void displayTopic(Mail mail) throws IOException {
		System.out.println("从topicQueue1取出消息"+mail.toString());
	}

	@RabbitListener(queues = "topicQueue2")
	public void displayTopic2(Mail mail) throws IOException {
		System.out.println("从topicQueue2取出消息"+mail.toString());
	}
}

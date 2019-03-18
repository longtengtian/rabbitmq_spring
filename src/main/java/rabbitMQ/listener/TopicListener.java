package rabbitMQ.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import po.Mail;

import java.io.IOException;


@Component
public class TopicListener {
	@RabbitListener(queues = "topicQueueOne")
	public void displayTopic(Mail mail) throws IOException {
		System.out.println("从topicQueueOne取出消息"+mail.toString());
	}

	@RabbitListener(queues = "topicQueueTwo")
	public void displayTopicTwo(Mail mail) throws IOException {
		System.out.println("从topicQueueTwo取出消息"+mail.toString());
	}
}

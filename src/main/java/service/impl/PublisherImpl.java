package service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.Mail;
import service.Publisher;

@Service("publisher")
public class PublisherImpl implements Publisher{
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public void publishMail(Mail mail) {
		rabbitTemplate.convertAndSend("fanout", "", mail);
	}

	@Override
	public void sendDirectMail(Mail mail, String routingkey) {
		rabbitTemplate.convertAndSend("direct", routingkey, mail);
	}

	@Override
	public void sendTopicMail(Mail mail, String routingkey) {
		rabbitTemplate.convertAndSend("myTopic", routingkey, mail);
	}

	
	
}

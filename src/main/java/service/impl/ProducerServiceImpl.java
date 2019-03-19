package service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Mail;
import service.ProducerService;

@Service("producerService")
public class ProducerServiceImpl implements ProducerService {
  @Autowired
  RabbitTemplate rabbitTemplate;

  @Override
  public void sendMail(String queue, Mail mail) {
    rabbitTemplate.setQueue(queue);
    rabbitTemplate.convertAndSend(queue, mail);
  }

}

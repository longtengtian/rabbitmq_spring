package rabbitMQ.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class TopicListener {
  // @RabbitListener(queues = "topicQueueOne")
  // public void displayTopic(Mail mail) throws IOException {
  // System.out.println("从topicQueueOne取出消息:\n" + mail.toString());
  // }
  //
  // @RabbitListener(queues = "topicQueueTwo")
  // public void displayTopicTwo(Mail mail) throws IOException {
  // System.out.println("从topicQueueTwo取出消息:\n" + mail.toString());
  // }

  @RabbitListener(queues = "topicQueueOne")
  public void displayTopic2(Channel channel, Message message) throws IOException {
    System.out.println("从topicQueueOne取出消息,手动肯定消息 start:\n" + new String(message.getBody(),
        "UTF-8"));
    channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    System.out.println("从topicQueueOne取出消息,手动肯定消息 end");
  }

  @RabbitListener(queues = "topicQueueTwo")
  public void displayTopicTwo2(Channel channel, Message message) throws IOException {
    System.out.println("从topicQueueOne取出消息,手动否定消息 start:\n" + new String(message.getBody(),
        "UTF-8"));
    // 最后一个参数 requeue 设置为true 会把消费失败的消息从新添加到队列的尾端，设置为false不会重新回到队列,可能会造成无限循环发送
    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
    System.out.println("从topicQueueOne取出消息,手动否定消息 end");
  }

}

package config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//生产者消费者模式的配置,包括一个队列和两个对应的消费者
@Configuration
public class ProducerConsumerConfig {
    @Autowired
    RabbitConfig rabbitconfig;

    @Bean
    public Queue myQueueOne() {
        Queue queue = new Queue("myQueue");
        return queue;
    }

}

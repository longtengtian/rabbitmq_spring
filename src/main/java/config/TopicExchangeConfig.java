package config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//topic交换机模型，需要一个topic交换机，两个队列和三个binding
@Configuration
public class TopicExchangeConfig {
	@Bean
 	public TopicExchange topicExchange(){
		TopicExchange topicExchange=new TopicExchange("myTopic");
 		return topicExchange;
 	}
	
	@Bean
    public Queue topicQueueOne() {
       Queue queue=new Queue("topicQueue1");
       return queue;
    }
 	
 	@Bean
    public Queue topicQueueTwo() {
       Queue queue=new Queue("topicQueue2");
       return queue;
    }
	
 	//3个binding将交换机和相应队列连起来
 	@Bean
 	public Binding bindingTopicOrange(){
 		Binding binding=BindingBuilder.bind(topicQueueOne()).to(topicExchange()).with("*.orange.*");//binding key
 		return binding;
 	}
 	
 	@Bean
 	public Binding bindingTopicRabbit(){
 		Binding binding=BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with("*.*.rabbit");
 		return binding;
 	}
 	
 	@Bean
 	public Binding bindingTopicLazy(){
 		Binding binding=BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with("lazy.#");//#表示0个或若干个关键字，*表示一个关键字
 		return binding;
 	}
}

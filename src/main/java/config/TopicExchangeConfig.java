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
    public Queue topicqueueOne() {
       Queue queue=new Queue("topicQueueOne");
       return queue;
    }
 	
 	@Bean
    public Queue topicQueueTwo() {
       Queue queue=new Queue("topicQueueTwo");
       return queue;
    }
	
 	//3个binding将交换机和相应队列连起来
 	@Bean
 	public Binding bindingTopic1(){
 		Binding binding=BindingBuilder.bind(topicqueueOne()).to(topicExchange()).with("*.orange.*");//binding key
 		return binding;
 	}
 	
 	@Bean
 	public Binding bindingTopic2(){
 		Binding binding=BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with("*.*.rabbit");
 		return binding;
 	}
 	
 	@Bean
 	public Binding bindingTopic3(){
 		Binding binding=BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with("lazy.#");//#表示0个或若干个关键字，*表示一个关键字
 		return binding;
 	}
}

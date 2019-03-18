package config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//direct直连模式的交换机配置,包括一个direct交换机，两个队列，三根网线binding
@Configuration
public class DirectExchangeConfig {
	@Bean
 	public DirectExchange directExchange(){
		DirectExchange directExchange=new DirectExchange("direct");
 		return directExchange;
 	}
	
	@Bean
    public Queue directQueueOne() {
       Queue queue=new Queue("directQueue1");
       return queue;
    }
 	
 	@Bean
    public Queue directQueueTwo() {
       Queue queue=new Queue("directQueue2");
       return queue;
    }
	
 	//3个binding将交换机和相应队列连起来
 	@Bean
 	public Binding bindingOrange(){
 		Binding binding=BindingBuilder.bind(directQueueOne()).to(directExchange()).with("orange");
 		return binding;
 	}
 	
 	@Bean
 	public Binding bindingBlack(){
 		Binding binding=BindingBuilder.bind(directQueueTwo()).to(directExchange()).with("black");
 		return binding;
 	}
 	
 	@Bean
 	public Binding bindingGreen(){
 		Binding binding=BindingBuilder.bind(directQueueTwo()).to(directExchange()).with("green");
 		return binding;
 	}
 	
 	
 	
}

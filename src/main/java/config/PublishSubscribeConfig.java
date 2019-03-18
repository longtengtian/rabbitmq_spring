package config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//发布订阅模式的配置,包括两个队列和对应的订阅者,发布者的交换机类型使用fanout(子网广播),两根网线binding用来绑定队列到交换机
@Configuration
public class PublishSubscribeConfig {
	@Autowired
	RabbitConfig rabbitconfig;

 	@Bean
	public Queue myQueueOne() {
       Queue queue=new Queue("queueOne");
       return queue;
    }
 	
 	@Bean
    public Queue myQueueTwo() {
       Queue queue=new Queue("queueTwo");
       return queue;
    }
 	
 	@Bean
 	public FanoutExchange fanoutExchange(){
 		FanoutExchange fanoutExchange=new FanoutExchange("fanout");
 		return fanoutExchange;
 	}
 	
 	@Bean
	public Binding bindingOne() {
		Binding binding = BindingBuilder.bind(myQueueOne()).to(fanoutExchange());
 		return binding;
 	}
 	
 	@Bean
	public Binding bindingTwo() {
 		Binding binding=BindingBuilder.bind(myQueueTwo()).to(fanoutExchange());
 		return binding;
 	}
 	
}

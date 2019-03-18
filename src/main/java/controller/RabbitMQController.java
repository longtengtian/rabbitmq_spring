package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Mail;
import po.TopicMail;
import service.Producer;
import service.Publisher;

@Controller
public class RabbitMQController {
	
	
	@Autowired
	Producer producer;
	
	@Autowired
	Publisher publisher;
	
	@RequestMapping(value="/produce",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public void produce(@ModelAttribute("mail")Mail mail) throws Exception{
		producer.sendMail("myQueueOne",mail);
	}
	
	@RequestMapping(value="/topic",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public void topic(@ModelAttribute("mail")Mail mail) throws Exception{
		publisher.publishMail(mail);
	}
	
	@RequestMapping(value="/direct",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public void direct(@ModelAttribute("mail")TopicMail mail){
		Mail m=new Mail(mail.getMailId(),mail.getCountry(),mail.getWeight());
		publisher.sendDirectMail(m, mail.getRoutingkey());
	}
	
	@RequestMapping(value="/myTopic",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public void topic(@ModelAttribute("mail")TopicMail mail){
		Mail m=new Mail(mail.getMailId(),mail.getCountry(),mail.getWeight());
		publisher.sendTopicMail(m, mail.getRoutingkey());
	}
	
	
	@RequestMapping("demo")
	public String demo(){
		return "demo";
	}
	
	
}

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import po.Mail;
import po.TopicMail;
import service.ProducerService;
import service.PublisherService;

@Controller
public class RabbitMQController {
	@Autowired
	private ProducerService producerService;
	@Autowired
	private PublisherService publisherService;

	@RequestMapping("demo")
	public String demo() {
		return "demo";
	}

	@RequestMapping(value = "/direct")
	@ResponseBody
	public void direct(@ModelAttribute("mail") TopicMail mail) {
		Mail m = new Mail(mail.getMailId(), mail.getCountry(), mail.getWeight());
		publisherService.sendDirectMail(m, mail.getRoutingkey());
	}

	@RequestMapping(value = "/produce")
	@ResponseBody
	public void produce(@ModelAttribute("mail")Mail mail) throws Exception{
		producerService.sendMail("myQueue", mail);
	}

	@RequestMapping(value = "/publish")
	@ResponseBody
	public void topic(@ModelAttribute("mail")Mail mail) throws Exception{
		publisherService.publishMail(mail);
	}

	@RequestMapping(value = "/topic")
	@ResponseBody
	public void topic(@ModelAttribute("mail")TopicMail mail){
		Mail m=new Mail(mail.getMailId(),mail.getCountry(),mail.getWeight());
		publisherService.sendTopicMail(m, mail.getRoutingkey());
	}

}

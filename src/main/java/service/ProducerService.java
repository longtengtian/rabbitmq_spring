package service;

import po.Mail;


public interface ProducerService {
	public void sendMail(String queue,Mail mail);//向队列queue发送消息
}

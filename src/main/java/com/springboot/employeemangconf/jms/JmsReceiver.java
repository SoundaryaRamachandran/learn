package com.springboot.employeemangconf.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
/**
 * JmsReceiver is to receive message from the activemq
 * @author Soundarya
 *
 */
@Component
public class JmsReceiver {
	/**
	 * getMessage to get message from the queue
	 * @param message
	 */
	@JmsListener(destination="learn")
	public void getMessage(String message) {
		System.out.println("Message received from the learn queue is ::"+message);
		System.out.println("Received message from the queue...");
	}
}




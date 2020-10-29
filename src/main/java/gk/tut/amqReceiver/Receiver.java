package gk.tut.amqReceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class Receiver {

	private final Logger logger = LoggerFactory.getLogger(Receiver.class);
		
	@JmsListener(destination = "${destination.name}")
	public void showReceivedMessage(String message) {
		logger.info("Message received: {} ", message);
	}
}

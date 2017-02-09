package alloc.kafka;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaReceiver {

	 private static final Logger LOGGER = LoggerFactory
	            .getLogger(KafkaReceiver.class);

	    private CountDownLatch latch = new CountDownLatch(1);

	    @KafkaListener(topics = "darsan")
	    public void receiveMessage(String message) {
	        LOGGER.info("received message='{}'", message);
	        latch.countDown();
	    }

	    public CountDownLatch getLatch() {
	        return latch;
	    }
}

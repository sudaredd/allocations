package alloc.controller;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllocController {

	private static final Logger log = LoggerFactory
            .getLogger(AllocController.class);
	private AtomicLong counter = new AtomicLong();

	@RequestMapping("/")
	private String requestAlloc() {
		log.info("requester:" + counter.incrementAndGet());
		// sleep(1);
		log.info("processed request#:" + counter.get() + " ,by:"
				+ Thread.currentThread().getName());
		return "Hello W:" + counter.get();
	}

	private void sleep(int secs) {
		try {
			TimeUnit.SECONDS.sleep(secs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

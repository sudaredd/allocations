package alloc.kafka;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaApplicationTests {

	 @Autowired
	 private KafkaSender kafkaSender;

	 @Autowired
	 private KafkaReceiver kafkaReceiver;

	    @Test
	    public void testReceiver() throws Exception {
	    	kafkaSender.sendMessage("darsan", "Hello Spring Kafka!");

	        kafkaReceiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	        assertThat(kafkaReceiver.getLatch().getCount()).isEqualTo(0);
	    }
}

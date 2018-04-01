package alloc.kafka.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringKafkaApplicationReceiverMain implements CommandLineRunner {

	 @Autowired
	 private KafkaReceiver kafkaReceiver;

	    public static void main(String[] args)  {
	//		SpringApplication.run(SpringKafkaApplicationReceiverMain.class, args);
			new SpringApplicationBuilder(SpringKafkaApplicationReceiverMain.class)
			.web(false).run(args);
	    }


		@Override
		public void run(String... args) throws Exception {

		}
}

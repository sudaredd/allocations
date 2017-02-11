package alloc.kafka.receiver;

import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import alloc.AllocationsApplication;
import alloc.ftp.FtpApplication;
import alloc.kafka.receiver.KafkaReceiver;
import static org.assertj.core.api.Assertions.assertThat;

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

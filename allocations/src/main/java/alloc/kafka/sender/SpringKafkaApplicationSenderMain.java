package alloc.kafka.sender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
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
import alloc.kafka.receiver.KafkaReceiver;
import alloc.kafka.receiver.SpringKafkaApplicationReceiverMain;
import static org.assertj.core.api.Assertions.assertThat;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringKafkaApplicationSenderMain implements CommandLineRunner {

	 @Autowired
	 private KafkaSender kafkaSender;

	// @Autowired
	 private KafkaReceiver kafkaReceiver;

	    public static void main(String[] args)  {
	    	
	//		SpringApplication.run(SpringKafkaApplicationSenderMain.class, args);
			
			new SpringApplicationBuilder(SpringKafkaApplicationSenderMain.class)
			.web(false).run(args);

	        /*kafkaReceiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
	        assertThat(kafkaReceiver.getLatch().getCount()).isEqualTo(0);*/
	    }
		static String fixMsg = 	"8=FIX.4.29=17535=D49=SENDER56=TARGET34=24850=frg52=20100702-11:12:4211=BS0100035492400021=3100=J55=ILA SJ48=YY7722=5167=CS207=J54=160=20100702-11:12:4238=50040=115=ZAR59=010=230";


		private void sendMsg() {
/*			IntConsumer intConsumer = (int i)-> kafkaSender.sendMessage("darsan", i+":"+fixMsg);
	    	IntStream.rangeClosed(1, 20000).forEach(intConsumer);
*/	    	int size = 200;
ExecutorService executor = Executors.newFixedThreadPool(4);
	    	for(int i=0; i<size;i++) {
	    		//final int ii=i;
	    	//	executor.execute(()->kafkaSender.sendMessage("darsan", ii+":"+fixMsg));
	    		kafkaSender.sendMessage("darsan", i+":"+fixMsg);
	    	}

		}

		@Override
		public void run(String... args) throws Exception {

			sendMsg();
		}
}

package alloc;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


@EnableAutoConfiguration
@ComponentScan(basePackages="alloc",
	excludeFilters= @ComponentScan.Filter(type = FilterType.ASPECTJ,pattern="alloc.controller.*"))
@SpringBootApplication
public class AllocationsApplication implements CommandLineRunner {

	private static Logger log = Logger.getLogger(AllocationsApplication.class);
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Override
	public void run(String... arg0) throws Exception {
		//jmsTemplate.convertAndSend("test", "testMsg");
		
		Message<String> testMsg = MessageBuilder.withPayload("testMsgWithheader").
				setHeader("header1", "ftp").setHeader("header2", "cme").build();
		jmsMessagingTemplate.send("test",testMsg);
	}
	
	@Component
	protected static class orderHandler {
		@JmsListener(destination="test")
		@SendTo("testStatus")
		public String handleMsg(String msg,  @Headers Map<String, String> headers) {
			log.info("msg received:"+msg + ", headers:"+headers.get("header1")+"__"+headers.get("header2"));
			return msg+" test status";
		}
	}
	
	@Component
	protected static class OrderStatusHandler {
		@JmsListener(destination = "testStatus")
		public void handleMsg(String statusMsg) {
			log.info("msg received:"+statusMsg);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AllocationsApplication.class, args);
    }
}
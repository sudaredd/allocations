package alloc.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

public class AllocControllerClient {

	private static Logger log = Logger.getLogger(AllocControllerClient.class);

	public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        
        IntStream.rangeClosed(1, 1000000)
        .parallel()
        .forEach(i->
        		{
        			String quote = restTemplate.getForObject("http://localhost:9001", String.class);
        			log.info(quote+Thread.currentThread().getName());
        		}      		
        );
        
	}
}

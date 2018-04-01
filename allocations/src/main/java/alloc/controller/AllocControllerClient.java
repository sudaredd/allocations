package alloc.controller;

import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class AllocControllerClient {

	private static final Logger log = LoggerFactory
            .getLogger(AllocControllerClient.class);
	public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        
        IntStream.rangeClosed(1, 2)
        .parallel()
        .forEach(i->
        		{
        			String quote = restTemplate.getForObject("http://localhost:9001", String.class);
        			log.info(quote+Thread.currentThread().getName());
        		}      		
        );
        
	}
}

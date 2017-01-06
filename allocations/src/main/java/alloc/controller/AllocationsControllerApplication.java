package alloc.controller;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@ComponentScan(basePackages="alloc.controller")
@SpringBootApplication
public class AllocationsControllerApplication {

	private static Logger log = Logger.getLogger(AllocationsControllerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AllocationsControllerApplication.class, args);
    }
}
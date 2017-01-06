package alloc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllocController {

	   @RequestMapping("/")
	    String home() {
	        return "Hello W!";
	    }
}

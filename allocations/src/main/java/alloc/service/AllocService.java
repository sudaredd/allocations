package alloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocService {

	@Autowired
	private NameService nameService;
	
	public String getUserName(String name) {
		return nameService.getUserName(name);
	}
}

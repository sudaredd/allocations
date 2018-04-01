package alloc.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@Import({AllocServiceApplication.class})
public class AlloactionServiceTest {

	@Autowired
	private NameService nameService;
	
	@Autowired
	private AllocService allocService;
	
	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
		when(nameService.getUserName("darsan")).thenReturn("Mocked darsan");
		String testName = allocService.getUserName("darsan");
		Assert.assertEquals("Mocked darsan", testName);
	}
}

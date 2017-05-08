package alloc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
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

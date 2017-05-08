package alloc.service;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class NameServiceTestConfiguration {

	@Bean
	@Primary
	public NameService nameservice() {
		return Mockito.mock(NameService.class);
	}
}

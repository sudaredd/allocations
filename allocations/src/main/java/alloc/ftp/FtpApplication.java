package alloc.ftp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageSources;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.messaging.MessageHandler;

@SpringBootApplication
public class FtpApplication {
	
	private static Logger log = Logger.getLogger(FtpApplication.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(FtpApplication.class)
		.web(false).run(args);
	}
	@Bean
    public SessionFactory<FTPFile> ftpSessionFactory() {
        DefaultFtpSessionFactory sf = new DefaultFtpSessionFactory();
        sf.setHost("localhost");
        sf.setPort(21);
        sf.setUsername("sudaredd");
        sf.setPassword("");
        return new CachingSessionFactory<FTPFile>(sf);
    }
	
	 @Bean
	    public IntegrationFlow ftpInboundFlow() {
	        return IntegrationFlows
	            .from((MessageSources s) -> s.ftp(ftpSessionFactory())
	                    .preserveTimestamp(true)
	                    .remoteDirectory("")
	                    .deleteRemoteFiles(true)
	                    .autoCreateLocalDirectory(true)
	                    .regexFilter(".*\\.(txt|csv|pdf)$")
	                    .temporaryFileSuffix("temp")
	                    .localDirectory(new File("C://ftp//ftpInbound//local")),
	                e -> e.id("ftpInboundAdapter")
	                    .autoStartup(true)
	                    .poller(Pollers.fixedDelay(15000)))
	                    .channel("ftpInboundChannel").get();
	    }
	  
	 @Bean
	    @ServiceActivator(inputChannel = "ftpInboundChannel")
	    public MessageHandler handleFtpFile() {
		 return  e-> {
			 log.info("file name is:"+e.getPayload());
			 try {
             	File file = (File)e.getPayload();
					Files.readAllLines(file.toPath())
					.forEach(log::info);
				} catch (IOException e1) {
					log.error("error ocuured while reding file:",e1);
				}
		 };
	 }
}

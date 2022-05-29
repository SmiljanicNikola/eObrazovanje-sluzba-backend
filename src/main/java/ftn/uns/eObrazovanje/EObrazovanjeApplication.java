package ftn.uns.eObrazovanje;

import org.springframework.boot.CommandLineRunner;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ftn.uns.eObrazovanje.service.FilesStorageService;

@SpringBootApplication
public class EObrazovanjeApplication implements CommandLineRunner{
	@Resource
	FilesStorageService storageService;	
	
	public static void main(String[] args) {
		SpringApplication.run(EObrazovanjeApplication.class, args);
	}

	@Override
	  public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }
	
	

}

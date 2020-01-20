package br.com.pamcary.api.evento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class InfologRiscosApiEventosApplication extends SpringBootServletInitializer {

	
	/*Procedimento para executar no servidor de aplicação sem Tomcat embarcado*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InfologRiscosApiEventosApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(InfologRiscosApiEventosApplication.class, args);
	}
}

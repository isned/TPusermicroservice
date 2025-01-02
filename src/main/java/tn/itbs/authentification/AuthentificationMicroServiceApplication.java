package tn.itbs.authentification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
@RefreshScope
@SpringBootApplication
@EnableDiscoveryClient
public class AuthentificationMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthentificationMicroServiceApplication.class, args);
	}

}

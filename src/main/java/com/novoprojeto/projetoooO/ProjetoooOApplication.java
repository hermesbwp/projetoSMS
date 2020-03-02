package com.novoprojeto.projetoooO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controller")
public class ProjetoooOApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoooOApplication.class, args);
	}

}

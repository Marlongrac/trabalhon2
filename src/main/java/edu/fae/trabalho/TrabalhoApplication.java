package edu.fae.trabalho;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class TrabalhoApplication {

	//Dados iniciais da base de dados
	@Bean
	CommandLineRunner runner(){
		return args -> {

			
		};
	}	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TrabalhoApplication.class, args);
	}
}

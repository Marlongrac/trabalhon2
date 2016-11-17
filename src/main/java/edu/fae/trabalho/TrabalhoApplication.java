package edu.fae.trabalho;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.fae.trabalho.model.Usuario;
import edu.fae.trabalho.repository.UsuarioRepository;


@SpringBootApplication
public class TrabalhoApplication {

	//Dados iniciais da base de dados
//	@Bean
//	CommandLineRunner criaUsuarios(UsuarioRepository usuarioRepository){
//		return args -> {
//			Usuario usuario = new Usuario();
//			usuario.setNome("Admin");
//			usuario.setEmail("admin@fae.edu");
//			usuario.setPassword("12345");
//			usuarioRepository.save(usuario);			
//		};
//	}	
	
	
	public static void main(String[] args) {
		SpringApplication.run(TrabalhoApplication.class, args);
	}
}

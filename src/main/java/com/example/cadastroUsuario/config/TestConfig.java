package com.example.cadastroUsuario.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.cadastroUsuario.entities.Address;
import com.example.cadastroUsuario.entities.User;
import com.example.cadastroUsuario.repositories.AddressRepository;
import com.example.cadastroUsuario.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//User u1 = new User(null, "Maria Brown", "maria@gmail.com", 98884488L);
		//User u2 = new User(null, "Alex Green", "alex@gmail.com", 9777766L); 
		
		//Address a1 = new Address(null, "Raimundo Aexandre", 190, "próximo ao Chama2","Paraíso 4", "Naviraí", "MS", 79950000L, u1);
	//	Address a2 = new Address(null, "José Bonifácio", 550, "próximo ao Senai","Centro", "Naviraí", "MS", 79950000L, u1);
		
		//userRepository.saveAll(Arrays.asList(u1, u2));
		//addressRepository.saveAll(Arrays.asList(a1, a2));
	}
}

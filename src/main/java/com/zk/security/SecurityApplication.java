package com.zk.security;

import com.zk.security.model.ERole;
import com.zk.security.model.Role;
import com.zk.security.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRepository roleRepository){
		return args -> {
			List<Role> listOfRoles = new ArrayList<>();
			for (ERole role: ERole.values()){
				listOfRoles.add(new Role(role));
			}

			roleRepository.saveAll(listOfRoles);
		};
	}



}

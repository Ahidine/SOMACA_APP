package org.Sid;

import org.Sid.dao.RoleRepository;
import org.Sid.dao.UserRepository;
import org.Sid.entities.roles;
import org.Sid.entities.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PfaApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PfaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	/*	roles r1=new roles("ADMIN");
		roles r2=new roles("ADMIN");
		roleRepository.save(r1);
		roleRepository.save(r2);
		
		userRepository.save(new users("hidine","hidine",r1));
		userRepository.save(new users("achraf","hidine",r2));	*/
		
	}

}

package nl.hsleiden;

import nl.hsleiden.model.Role;
import nl.hsleiden.model.User;
import nl.hsleiden.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	CommandLineRunner run(UserService userService){
		return args -> {
//		userService.saveRole(new Role("ROLE_USER"));
//		userService.saveRole(new Role("ROLE_ADMIN"));
//
//		userService.saveUser(new User("bruno@notmail.com","test123","pretraket"));
//
//		userService.addRoleToUser("pretraket","ROLE_ADMIN");
		};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}





}

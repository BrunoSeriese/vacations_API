package nl.hsleiden.DAO.config;

import nl.hsleiden.DAO.repository.RoleRepository;
import nl.hsleiden.DAO.repository.UserRepository;
import nl.hsleiden.model.Role;
import nl.hsleiden.model.User;
import nl.hsleiden.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
public class UserConfig {



    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository, UserService userService, RoleRepository roleRepository) {
        return args -> {
            if (userRepository.findByUsername("adminAcc")== null){
                if (roleRepository.findByName("ROLE_ADMIN") == null){
                    userService.saveRole(new Role(1,"ROLE_ADMIN"));
                }

                userService.saveUser(new User("adminMail@gmail.com","test123","adminAcc"));
                userService.addRoleToUser("adminAcc","ROLE_ADMIN");
            }

        };






    }
}

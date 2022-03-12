package nl.hsleiden.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import nl.hsleiden.model.Role;
import nl.hsleiden.model.User;
import nl.hsleiden.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping("/role/grantroletouser")
    public ResponseEntity<?>grantRole(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(),form.getRoleNamne());
        return ResponseEntity.ok().build();
    }
    @Data
    class RoleToUserForm{
        private String username;
        private String roleNamne;
    }
}

package nl.hsleiden.service;

import nl.hsleiden.model.Role;
import nl.hsleiden.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User>getUsers();
}

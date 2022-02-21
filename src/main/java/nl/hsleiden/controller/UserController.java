package nl.hsleiden.controller;

import nl.hsleiden.model.User;
import nl.hsleiden.model.Vacation;
import nl.hsleiden.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewVacation(@RequestBody User user) {
        userService.addUser(user);
    }

   @PostMapping({"/login"})
   @ResponseStatus(HttpStatus.ACCEPTED)
   @ResponseBody
   public String login(@RequestBody User user) throws Exception {

      return "Hello FUCKING WORK";
    }
}

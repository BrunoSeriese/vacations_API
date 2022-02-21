package nl.hsleiden.service;

import nl.hsleiden.DAO.repository.UserRepository;
import nl.hsleiden.model.User;
import nl.hsleiden.model.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public void addUser(User user) {
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    @Transactional(rollbackFor = Exception.class)
    public long saveDto(User userDto) {
        userDto.setPassword(this.bCryptPasswordEncoder
                .encode(userDto.getPassword()));
        return userRepository.save((userDto)).getId();
    }

    @Autowired
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}

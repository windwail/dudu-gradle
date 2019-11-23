package ru.dudu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dudu.dto.RegisterUser;
import ru.dudu.model.UserAccaunt;
import ru.dudu.repository.UserRepository;

import java.util.Optional;

@RestController
public class UserController {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ResponseEntity<UserAccaunt> login(@RequestParam String login, @RequestParam String password) {
        Optional<UserAccaunt> user =  userRepository.findByLogin(login);
        if(user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccaunt> register(@RequestBody RegisterUser user) {
        UserAccaunt userAccaunt = new UserAccaunt(
                user.getLogin(),
                user.getEmail(),
                user.getPassword()
        );
        return ResponseEntity.ok(userRepository.save(userAccaunt));
    }

}

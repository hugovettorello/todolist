package br.com.hugovettorello.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController

@RequestMapping("/users")
public class UserController {
    

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel usermodel){

        var user = this.userRepository.findByUsername(usermodel.getUsername());

        if(user != null) {
            System.out.println("Usuário já existe");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }
        
        var passwordHashred = BCrypt.withDefaults().hashToString(12, usermodel.getPassword().toCharArray());

        usermodel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(usermodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);

    }

}

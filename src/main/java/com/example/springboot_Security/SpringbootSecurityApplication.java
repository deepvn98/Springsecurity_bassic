package com.example.springboot_Security;

import com.example.springboot_Security.model.Role;
import com.example.springboot_Security.model.User;
import com.example.springboot_Security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityApplication.class, args);
    }


//@Autowired
//private PasswordEncoder passwordEncoder;
//@Bean
//CommandLineRunner run(UserService userService) {
//        return args -> {
//            userService.saveUser(new User( "sang", "npsang" , "npsang@gmail.com",passwordEncoder.encode("123456"), new ArrayList<>()));
//            userService.saveUser(new User( "dieu", "ntdieu" , "ntdieu@gmail.com",passwordEncoder.encode("123456"), new ArrayList<>()));
//            userService.saveUser(new User( "anh", "npanh", "npanh@gmail.com",passwordEncoder.encode("123456"), new ArrayList<>()));
//
//            userService.addRoleToUser("npsang", "ROLE_ADMIN");
//            userService.addRoleToUser("npsang", "ROLE_MEMBER");
//            userService.addRoleToUser("ntdieu", "ROLE_ADMIN");
//            userService.addRoleToUser("npanh", "ROLE_MEMBER");
//        };
//    }
}

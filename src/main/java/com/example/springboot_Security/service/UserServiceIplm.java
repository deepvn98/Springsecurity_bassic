package com.example.springboot_Security.service;

import com.example.springboot_Security.model.Role;
import com.example.springboot_Security.model.User;
import com.example.springboot_Security.repo.RoleRepo;
import com.example.springboot_Security.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceIplm implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("save new user{} to database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saverRole(Role role) {
        log.info("save new role{} to database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role{} to user{}", roleName, roleName);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username) ;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }
        else {
            log.error("User found in the database",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
    }
}

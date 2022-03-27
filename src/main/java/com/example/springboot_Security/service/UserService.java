package com.example.springboot_Security.service;

import com.example.springboot_Security.model.Role;
import com.example.springboot_Security.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saverRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}

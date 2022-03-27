package com.example.springboot_Security.config;

import com.example.springboot_Security.model.Role;
import com.example.springboot_Security.repo.RoleRepo;
import com.example.springboot_Security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Roles
        if (roleRepo.findByName("ROLE_ADMIN") == null) {
            roleRepo.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepo.findByName("ROLE_MEMBER") == null) {
            roleRepo.save(new Role("ROLE_MEMBER"));
        }
    }
}

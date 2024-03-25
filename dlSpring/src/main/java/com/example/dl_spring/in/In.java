package com.example.dl_spring.in;


import com.example.dl_spring.model.Role;
import com.example.dl_spring.model.User;
import com.example.dl_spring.repository.RoleRepository;
import com.example.dl_spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class In implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public void run(String... arg) throws Exception {
        Role roleUser = new Role("ROLE_USER");
        Set<Role> userRoles = new HashSet<>();
        if (roleRepository.findByName("ROLE_USER") == null) {
            roleRepository.save(roleUser);
        }
        userRoles.add(roleUser);
        if (userRepository.findByName("user") == null) {
            User userUser = new User("user", passwordEncoder.encode("user"), userRoles);
            userRepository.save(userUser);
        }
    }
}
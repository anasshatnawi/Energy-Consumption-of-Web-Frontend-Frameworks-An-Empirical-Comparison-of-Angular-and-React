package com.example.petstoremonolithique.Services;

import com.example.petstoremonolithique.Entities.User;
import com.example.petstoremonolithique.Entities.UserStatus;
import com.example.petstoremonolithique.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        
        User foundUser = user.get();
        return org.springframework.security.core.userdetails.User.builder()
                .username(foundUser.getEmail())
                .password(foundUser.getPassword())
                .authorities(new ArrayList<>())
                .build();
    }
    
    public User createUser(String email, String password, PasswordEncoder passwordEncoder) {
        if (userRepository.findByEmail(email).isPresent()) {
            return userRepository.findByEmail(email).get();
        }
        
        User user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .status(UserStatus.Active)
                .build();
        
        return userRepository.save(user);
    }
}
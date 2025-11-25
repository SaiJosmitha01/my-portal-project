package com.myportal.my_portal.service;

import com.myportal.my_portal.User;
import com.myportal.my_portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User saveUser(User user) {
        // Encrypt password before saving
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // ⭐ NEW update method
    public User updateUser(User user) {
        // If password is changed, encrypt it
        if (!user.getPassword().startsWith("$2a$")) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }
}

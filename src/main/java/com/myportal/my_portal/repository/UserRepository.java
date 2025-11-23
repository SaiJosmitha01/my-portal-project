package com.myportal.my_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myportal.my_portal.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

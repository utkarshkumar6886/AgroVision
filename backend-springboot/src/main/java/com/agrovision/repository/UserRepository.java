package com.agrovision.repository;

import com.agrovision.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // check if email already exists
    boolean existsByEmail(String email);

    // used for login
    User findByEmail(String email);
}

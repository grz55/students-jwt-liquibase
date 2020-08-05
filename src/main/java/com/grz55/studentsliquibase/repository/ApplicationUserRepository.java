package com.grz55.studentsliquibase.repository;

import com.grz55.studentsliquibase.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<UserDetails> findByUsername(String username);

}

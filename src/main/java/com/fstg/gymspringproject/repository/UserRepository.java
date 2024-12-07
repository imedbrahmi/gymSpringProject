package com.fstg.gymspringproject.repository;

import com.fstg.gymspringproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);

    void deleteById(Long id);

    Optional<User> findById(Long id);
}

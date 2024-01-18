package hello.hello.spring.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hello.spring.DTO.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}

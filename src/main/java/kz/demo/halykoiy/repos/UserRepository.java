package kz.demo.halykoiy.repos;

import kz.demo.halykoiy.entities.User;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Since phone is unique, we'll find users by phone
    Optional<User> findByPhone(String phone);
}
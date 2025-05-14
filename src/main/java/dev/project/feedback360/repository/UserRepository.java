package dev.project.feedback360.repository;

import dev.project.feedback360.models.UserEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

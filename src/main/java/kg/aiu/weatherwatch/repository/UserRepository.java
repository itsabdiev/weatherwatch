package kg.aiu.weatherwatch.repository;

import kg.aiu.weatherwatch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String email);

    boolean existsByUsername(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET deleted = NOW() WHERE username = ?",nativeQuery = true)
    void delete(String username);
}

package kg.aiu.weatherwatch.service;

import kg.aiu.weatherwatch.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User loadUserByEmail(String email);

    boolean existsByEmail(String email);

    void save(User user);

    void delete(String username);
}

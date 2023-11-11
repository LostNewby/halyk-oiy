package kz.demo.halykoiy.services;

import kz.demo.halykoiy.entities.Role;
import kz.demo.halykoiy.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    void setRole(User user, Role role);
    void setLocation(User user, Double latitude, Double longitude);
    User getUserByPhone(String phone);
}